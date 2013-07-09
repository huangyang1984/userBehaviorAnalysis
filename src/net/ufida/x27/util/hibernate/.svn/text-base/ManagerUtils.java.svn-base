package net.ufida.x27.util.hibernate;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.Assert;

public class ManagerUtils {
    
    private static final Logger log = Logger.getLogger(ManagerUtils.class);
    
    /**
     * 根据传入的对象，构造精确匹配的查询对象，构造的过程只根据非空的属性构造，而且目前只支持基本属性
     * @param example 查询用途的对象，必须是有具体类型，需要调用它的getClass()
     * @return
     * @deprecated
     */
    public static DetachedCriteria getCriteriaByExample(Object example) {
        return getCriteriaByExample(example, false);
    }
    
    /**
     * 根据传入的对象，构造查询对象，构造的过程只根据非空的属性构造，而且目前只支持基本属性
     * @param example 查询用途的对象，必须是有具体类型，需要调用它的getClass()
     * @param isLike true表示所有的属性都是模糊查询，反之都是精确匹配
     * @return
     * @deprecated
     */
    public static DetachedCriteria getCriteriaByExample(Object example, boolean isLike) {
        Example exampleTemp = Example.create(example);
        if (isLike) {
            exampleTemp.enableLike(MatchMode.ANYWHERE);
        }
        DetachedCriteria dc = DetachedCriteria.forClass(example.getClass());
        dc.add(exampleTemp);
        return dc;
    }
    
    /**得到如下语句：AND (idStr='1' OR idStr='2')
     * @param dc DetachedCriteria
     * @param idList Collection<String>
     * @param idName 如果isEmpty的话，采用BaseManager.ID_NAME（idStr）
     */
    public static void genIdOr(DetachedCriteria dc, Collection idList, String idName) {
        Assert.notNull(idList);
        if (StringUtils.isEmpty(idName)) {
            idName = BaseManager.ID_NAME;
        }
        Junction junction = Restrictions.disjunction();
        for (Iterator iterator = idList.iterator(); iterator.hasNext();) {
            String id = (String) iterator.next();
            junction.add(Restrictions.eq(idName, id));
        }
        dc.add(junction);
    }
    
    /**
     * 用System.out.println打印一个collect中的所有元素，先打印该列表的大小
     * @param collect 要打印的向量
     */
    public static void printList(Collection collect) {
        if (collect == null) {
            System.out.println("collect is null");
            return;
        }
        System.out.println("size:" + collect.size());
        for (Iterator iter = collect.iterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }

}
