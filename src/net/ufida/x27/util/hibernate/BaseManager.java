package net.ufida.x27.util.hibernate;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.ufida.x27.util.text.StrUtils;
import net.ufida.x27.util.web.Page;
import net.ufida.x27.util.web.PageParam;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

/**此类不仅仅是为了Manager类的方便使用，在特定场景下是为了在ServiceImpl中能够直接调用。
 */
public abstract class BaseManager extends HibernateDaoSupport {
    
    /**统一的ID的属性名称：idStr*/
    public static final String ID_NAME = "idStr";
    
    /**日志对象*/
    protected final Logger log = Logger.getLogger(getClass());
    
    /**
     * 获取count
     * @param criteria
     * @return
     */
	public int count(DetachedCriteria dc) {
        Criteria criteria = dc.getExecutableCriteria(getSession());
        criteria.setProjection(Projections.rowCount());
        int size = ((Integer) criteria.uniqueResult()).intValue();
        return ((Integer) criteria.uniqueResult()).intValue();
	}

    /**通过子类实现这个方法，得到Model的类型
     * @return Model的类型
     */
    public abstract Class getModelClass();
    
    /**得到当前处理Model的class的simpleName
     * @return clazz.getSimpleName()
     * @see java.lang.Class#getSimpleName()
     */
    public String getSimpleClassName() {
        return ClassUtils.getShortClassName(getModelClass());
    }
    
    /**根据查询例子查询，只构造查询例子中非空的基本属性
     * example：
     * User user = new User();
     * user.setName("刘博宇");
     * findListByExample(user);
     * 此例子中，会自动寻找user中的非空基本属性，构造精确匹配的查询函数
     * @param example 查询例子
     * @return List<Model>
     * @see org.springframework.orm.hibernate3.HibernateTemplate#findByExample(Object)
     * @deprecated
     */
    public List findListByExample(Object example) {
        return getHibernateTemplate().findByExample(example);
    }
    
    /**得到一个初始化好的DetachedCriteria查询对象
     * @return DetachedCriteria查询对象
     * @see org.hibernate.criterion.DetachedCriteria#forClass(Class)
     */
    public DetachedCriteria getDetachedCriteria() {
        return DetachedCriteria.forClass(getModelClass());
    }
    
    /**根据hql得到一个查询对象
     * @param hql hql
     * @return Query
     * @see org.hibernate.Session#createQuery()
     */
    public Query getQuery(String hql) {
        return getSession().createQuery(hql);
    }
    
    /**得到一个Criteria查询对象
     * @return Criteria查询对象
     * @see org.hibernate.Session#getCriteria()
     */
    public Criteria getCriteria() {
        return getSession().createCriteria(getModelClass());
    }
    
    /**得到一个Criteria查询对象，并使用悲观锁
     * @return Criteria查询对象
     * @see org.hibernate.Session#getCriteria()
     * @see org.hibernate.Criteria#setLockMode(LockMode)
     */
    public Criteria getCriteria4Update() {
        return getCriteria().setLockMode(LockMode.UPGRADE);
    }
    
    /**清除向量中所有对象的缓存
     * @param collect 需要清理的向量
     * @see org.springframework.orm.hibernate3.HibernateTemplate#evict(Object)
     */
    public void evict(Collection collect) {
        for (Iterator iter = collect.iterator(); iter.hasNext();) {
            evict(iter.next());
        }
    }
    
    /**清除指定对象的缓存
     * @param id 实体对象id
     * @see org.springframework.orm.hibernate3.HibernateTemplate#evict(Object)
     */
    public void evict(String id) {
        evict(newInstance(id));
    }
    
    /**清除指定对象的缓存
     * @param entity 实体对象
     * @see org.springframework.orm.hibernate3.HibernateTemplate#evict(Object)
     */
    public void evict(Object entity) {
        getHibernateTemplate().evict(entity);
    }
    
    /**初始化向量中所有对象，确保不产生延迟加载的问题，但是要慎用，使用不当引起性能问题
     * @param collect 需要处理的向量
     */
    public void initialize(Collection collect) {
        for (Iterator iter = collect.iterator(); iter.hasNext();) {
            getHibernateTemplate().initialize(iter.next());
        }
    }
    
    /**初始化向量中所有对象，确保不产生延迟加载的问题，但是要慎用，使用不当引起性能问题
     * @param collect 需要处理的向量
     */
    public void initializeDeep(Collection collect) {
        for (Iterator iter = collect.iterator(); iter.hasNext();) {
            initializeDeep(iter.next());
        }
    }
    
    /**深度初始化指定对象，确保不产生延迟加载的问题，但是要慎用，使用不当引起性能问题
     * getHibernateTemplate().initialize(entity)只会初始化基本属性
     * @param entity 实体对象
     */
    public void initializeDeep(Object entity) {
        if (entity == null) {
            return;
        }
        getHibernateTemplate().initialize(entity);
        PropertyDescriptor[] pdArray = PropertyUtils.getPropertyDescriptors(entity);
        for (int i = 0; i < pdArray.length; i++) {
            PropertyDescriptor pd = pdArray[i];
            Method method = pd.getReadMethod();
            if (!ModelUtils.isGetMethod(method)) {
                continue;
            }
            Object getObj = ModelUtils.invokeGetMethod(entity, method);
            if (getObj instanceof Collection) {
                initializeDeep((Collection) getObj);
            }
        }
    }
    
    /**查询Model对应的表中的所有数据，测试专用
     * @return List<Model>
     */
    public List findList() {
        return getHibernateTemplate().loadAll(getModelClass());
    }
    
    /**查询Model对应的表中的所有数据，测试专用
     * @param orderByName 排序字段
     * @return List<Model>
     */
    public List findList(String orderByName) {
        DetachedCriteria dc = DetachedCriteria.forClass(getModelClass());
        dc.addOrder(Order.asc(orderByName));
        return findList(dc);
    }
    
    /**根据指定查询对象，查找数据库中的数据，如果符合条件的个数超过1个抛异常
     * @param dc 查询对象
     * @return Model
     * @see org.hibernate.Criteria#uniqueResult()
     */
    public Object findUniqueResult(DetachedCriteria dc) {
        return dc.getExecutableCriteria(getSession()).uniqueResult();
    }
    
    /**根据指定查询对象，查找数据库中的数据，取得第一个对象，collect为空的话返回null
     * @param dc 查询对象
     * @return Model
     */
    public Object findUniqueResultWithOutException(DetachedCriteria dc) {
        return dc.getExecutableCriteria(getSession()).setMaxResults(1).uniqueResult();
    }
    
    /**根据指定查询对象，查找数据库中的数据
     * @param dc 查询对象
     * @return List<Model>
     * @see org.springframework.orm.hibernate3.HibernateTemplate#findByCriteria(DetachedCriteria)
     */
    public List findList(DetachedCriteria dc) {
        return getHibernateTemplate().findByCriteria(dc);
    }
    
    /**根据指定查询对象，查找数据库中的数据，带分页参数
     * @param dc 查询对象
     * @param firstResult 第一条记录的位置
     * @param maxResults 最大记录数
     * @return List<Model>
     * @see org.springframework.orm.hibernate3.HibernateTemplate#findByCriteria(DetachedCriteria, int, int)
     */
    public List findList(DetachedCriteria dc, int firstResult, int maxResults) {
        return getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
    }
    
    /**根据指定查询对象，查找数据库中的数据，带分页参数
     * @param dc 查询对象
     * @param firstResult 第一条记录的位置
     * @param maxResults 最大记录数
     * @return List<Model>
     * @see org.springframework.orm.hibernate3.HibernateTemplate#findByCriteria(DetachedCriteria, int, int)
     */
    public List findList(Criteria criteria, int firstResult, int maxResults) {
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        return criteria.list();
    }
    
    /**添加一个对象
     * @param entity 需要添加的对象，添加后该游离对象的引用变成实体对象的引用
     * @return model包含了已有的idStr
     * @see org.springframework.orm.hibernate3.HibernateTemplate#save(Object)
     */
    public Object save(Object entity) {
        getHibernateTemplate().save(entity);
        return entity;
    }
    
    /**根据对象id删除对象
     * @param id 对象id
     */
    public void deleteById(String id) {
        List ids = new LinkedList();
        ids.add(id);
        deleteByIdList(ids);
    }
    
    private Modelable newInstance(String id) {
        Modelable param = (Modelable) ModelUtils.newInstance(getModelClass());
        param.setIdStr(id);
        return param;
    }
    
    /**根据对象id列表删除对象列表
     * @param ids 对象id列表，逗号分隔
     * @return 删除的个数
     */
    public int deleteByIds(String ids) {
        return deleteByIdList(StrUtils.str2List(ids));
    }
    
    /**根据对象id列表删除对象列表
     * @param idList 对象id列表
     * @return 删除的个数
     */
    public int deleteByIdList(Collection idList) {
        for (Iterator iterator = idList.iterator(); iterator.hasNext();) {
            String id = (String) iterator.next();
            evict(id);//清空缓存
        }
        if (idList == null || idList.size() == 0) {
            return 0;
        }
        String hql = null;
        if (idList.size() == 1) {
            hql = "DELETE " + getSimpleClassName() + " WHERE " + ID_NAME + "=?";
            log.info("hql : " + hql);//////////////
        } else {
            StringBuffer hqlBuf = new StringBuffer();
            for (Iterator iterator = idList.iterator(); iterator.hasNext();) {
                String id = (String) iterator.next();
                hqlBuf.append(",?");
            }
            hql = "DELETE " + getSimpleClassName() + 
                " WHERE " + ID_NAME + " IN (" + hqlBuf.delete(0, 1) + ")";
        }
        return getHibernateTemplate().bulkUpdate(hql, idList.toArray());
    }
    
    /**删除一个实体对象，如果能够事先得到对象id的话，推荐deleteById方法
     * @param entity
     * @see org.springframework.orm.hibernate3.HibernateTemplate#delete(Object)
     */
    public void delete(Object entity) {
        getHibernateTemplate().delete(entity);
    }
    
    /**更新一个持久化对象，如果只需要更新部分属性的话，推荐updateByParam方法
     * 例：更新一个字段为null，当然数据中该字段允许为空
     * User user = (User) userDao.findObjectById("1");
     * user.setName(null);
     * userDao.update(user);
     * @param entity 需要更新的持久化对象
     * @see org.springframework.orm.hibernate3.HibernateTemplate#update(Object)
     */
    public void update(Object entity) {
        getHibernateTemplate().update(entity);
    }
    
    /**根据BaseModel，取得需要更新对象的id，只更新model中非null的属性，有一句findById操作
     * 如果需要往数据库中更新null属性的话，只能用update方法，如果要对对应关联清缓存的话，也建议最终调用update方法
     * 本方法支持级联，但是使用时要注意，级联一对多的collection为null和size为0处理方式不一样的：
     * null不处理，但是size为0是有实际语义的，表示一对多的部分全部删除
     * 例：
     * User user = new User();
     * user.setId("1");
     * user.setName("刘博宇");
     * userDao.updateByParam(user);
     * 在上面这个例子中，会更新id为1的记录中的name为刘博宇，但是不会更新其它字段
     * @param param
     */
    public void updateByParam(Modelable param) {
        Object entity = findById(param.getIdStr());
        ModelUtils.transferValue(param, entity);
        getHibernateTemplate().update(entity);
    }
    
    /**根据指定id查询对象，如果改id的数据在数据中不存在，抛异常
     * @param id 指定id
     * @return model
     * @see org.springframework.orm.hibernate3.HibernateTemplate#load(Class, java.io.Serializable)
     */
    public Object findById(Serializable id) {
        return getHibernateTemplate().load(getModelClass(), id);
    }
    
    /**根据指定id查询对象，如果该id的数据在数据库中不存在，返回null，测试专用
     * @param id 指定id
     * @return model
     * @see org.springframework.orm.hibernate3.HibernateTemplate#get(Class, java.io.Serializable)
     */
    public Object findByIdAllowNull(Serializable id) {
        return getHibernateTemplate().get(getModelClass(), id);
    }
    
    public Query createQuery(String hql, Collection values) {
        return createQuery(hql, values.toArray());
    }
    
    /**创建Query对象. 对于需要first,max,fetchsize,cache,cacheRegion等诸多设置的函数,可以在返回Query后自行设置.
     * @param values Object[].
     * @return Query
     */
    public Query createQuery(String hql, Object[] values) {
        Assert.hasText(hql);
        if (values == null) {
            values = new Object[] {};
        }
        Query query = getQuery(hql);
        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        return query;
    }

    /**分页查询函数，使用hql
     * @param hql String
     * @param values Object[]
     * @param pageParam 页面查询参数
     * @param alias 排序表的别名，排序的时候才起作用
     * @return Page(totalProperty, list)
     */
    public Page findPage(String hql, Object[] values, PageParam pageParam, String alias) {
        Assert.hasText(hql);
        Assert.notNull(pageParam);
        if (values == null) {
            values = new Object[] {};
        }
        // Count查询
        String countQueryString = "SELECT COUNT(*) " + HqlUtils.removeSelect(HqlUtils.removeOrders(hql));
        long totalCount = ((Long) getHibernateTemplate().find(countQueryString, values).get(0)).longValue();
        if (StringUtils.isNotEmpty(pageParam.getSort())) {
            Assert.hasText(alias);
            hql = HqlUtils.removeOrders(hql);
            hql += " ORDER BY " + alias + "." + pageParam.getSort();
            if (pageParam.getDir().equals(PageParam.DIR_ASC)) {
                hql += " ASC";
            } else {
                hql += " DESC";
            }
        }
        // 实际查询返回分页对象
        Query query = createQuery(hql, values);
        query.setFirstResult(pageParam.getStart());
        query.setMaxResults(pageParam.getLimit());
        List list = query.list();
        return new Page((int) totalCount, list);
    }

    /**分页查询函数，使用已设好查询条件与排序的Criteria
     * @param criteria 查询对象
     * @param pageParam 页面查询参数
     * @return Page(totalProperty, list)
     */
    public Page findPage(Criteria criteria, PageParam pageParam) {
        Assert.notNull(criteria);
        Assert.notNull(pageParam);
        CriteriaImpl impl = (CriteriaImpl) criteria;
        // 先把Projection和OrderBy条件取出来,清空两者来执行Count操作
        Projection projection = impl.getProjection();
        //List<CriteriaImpl.OrderEntry>
        List orderEntries = (List) ModelUtils.forceGetProperty(impl, "orderEntries");
        ModelUtils.forceSetProperty(impl, "orderEntries", new ArrayList());
        criteria.setProjection(Projections.rowCount());
        // 执行查询
        int totalProperty = ((Integer) criteria.uniqueResult()).intValue();
        // 将之前的Projection和OrderBy条件重新设回去
        criteria.setProjection(projection);
        if (projection == null) {
            criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        }
        if (StringUtils.isNotEmpty(pageParam.getSort())) {
            if (pageParam.getDir().equals(PageParam.DIR_ASC)) {
                criteria.addOrder(Order.asc(pageParam.getSort()));
            } else {
                criteria.addOrder(Order.desc(pageParam.getSort()));
            }
        } else {
            ModelUtils.forceSetProperty(impl, "orderEntries", orderEntries);
        }
        criteria.setFirstResult(pageParam.getStart());
        criteria.setMaxResults(pageParam.getLimit());
        List list = criteria.list();
        Page page = new Page(totalProperty, list);
        page.setPageParam(pageParam);
        
        return page;
    }
    
    /**分页查询函数，使用已设好查询条件与排序的DetachedCriteria
     * @param dc DetachedCriteria
     * @param pageParam 页面查询参数
     * @return Page(totalProperty, list)
     */
    public Page findPage(DetachedCriteria dc, PageParam pageParam) {
        return findPage(dc.getExecutableCriteria(getSession()), pageParam);
    }
    
    /**判断对象某些属性的值在数据库中是否唯一
     * @param entity 如果有id认为是update
     * @param uniquePropertyName 在POJO里不能重复的属性
     * @param ex 如果这个参数为空的话，不返回false直接抛异常。
     * @return boolean
     */
    public boolean isUnique(Modelable entity, String uniquePropertyName, RuntimeException ex) {
        List uniquePropertyNames = new LinkedList();
        uniquePropertyNames.add(uniquePropertyName);
        return isUnique(true, entity, uniquePropertyNames, ex);
    }
    
    /**判断对象某些属性的值在数据库中是否唯一
     * @param isAnd true表示uniquePropertyNames中的参数采用and的查询条件组合，反之表示采用or的查询条件组合
     * @param entity 如果有id认为是update
     * @param uniquePropertyNames 在POJO里不能重复的属性列表
     * @param ex RuntimeException 如果不为空，而且返回值是false的话抛出此异常
     * @return boolean
     */
    public boolean isUnique(boolean isAnd, Modelable entity, List uniquePropertyNames, RuntimeException ex) {
        DetachedCriteria dc = getDetachedCriteria();
        dc.setProjection(Projections.rowCount());
        Junction junction = null;
        if (isAnd) {
            junction = Restrictions.conjunction();
        } else {
            junction = Restrictions.disjunction();
            
        }
        for (Iterator iterator = uniquePropertyNames.iterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            junction.add(Restrictions.eq(name, ModelUtils.getProperty(entity, name)));
        }
        dc.add(junction);
        // 以下代码为了如果是update的情况,排除entity自身.
        String idStr = entity.getIdStr();
        if (idStr != null) {
            dc.add(Restrictions.ne(ID_NAME, idStr));
        }
        boolean ret = ((Integer) findUniqueResult(dc)).intValue() == 0;
        if (ret == false && ex != null) {
            throw ex;
        }
        return ret;
    }
    
    /**取得对象的主键名
     * @return idName
     */
    public String getIdName() {
        Class clazz = getModelClass();
        ClassMetadata meta = getSessionFactory().getClassMetadata(clazz);
        Assert.notNull(meta, "Class " + clazz.getName() + " not define in hibernate session factory.");
        String idName = meta.getIdentifierPropertyName();
        Assert.hasText(idName, clazz.getName() + " has no identifier property define.");
        return idName;
    }
    
    /**
     * 刷新
     */
    public void flush() {
        getHibernateTemplate().flush();
    }

}
