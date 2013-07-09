package net.ufida.x27.core.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.ufida.x27.core.model.Organization;
import net.ufida.x27.core.model.User;
import net.ufida.x27.dict.util.DictEnumCfg;
import net.ufida.x27.util.hibernate.BaseManager;
import net.ufida.x27.util.web.Page;
import net.ufida.x27.util.web.PageParam;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * 
 * @author Steven.yang
 *
 */
public class UserManager extends BaseManager {
    
    public void updateUserStatus(String userId, String userStatus) {
        User user = new User(userId);
        user.setUserStatus(userStatus);
        user.setRoles(null);
        user.setOrganizations(null);
        
        super.updateByParam(user);
    }
    
    public User save(User user) {
        user.setUserStatus(DictEnumCfg.USER_STATUS_normal);
        return (User) super.save(user);
    }

    public Class getModelClass() {
        return User.class;
    }
    
    public User findByEmail(String email) {
        User example = new User();
        example.setEmail(email);
        return (User) super.findUniqueResult(getFindListCriteria(example));
    }

    public User findByUserName(String userName) {
        User example = new User();//
        example.setUserName(userName);
        return (User) super.findUniqueResult(getFindListCriteria(example));
    }
    /**
     * 
     * @param userName
     * @return
     * @deprecated
     */
    public String findOrgByUserName(String  userName) {
        User user = findByUserName(userName);
        Organization org;
        if(user.getOrganizations().isEmpty()) {
            return "706640124"; 
        }else {
           org =(Organization) user.getOrganizations().get(0);
        } 
        return org.getOrgCode();
    }
    /**
     * 查询所有未被引用过的用户
     * @return
     */
//    public List findAllNotCitedByBrokerUsers() {
//        Criteria criteia = getSession().createCriteria(User.class,"us");
//        criteia.add(Subqueries.notExists(
//                DetachedCriteria.forClass(Broker.class)
//                .setProjection(Projections.property("idStr"))
//                .add(Restrictions.eqProperty("user.idStr", "us.idStr"))
//            )
//        );
//        return criteia.list();
//    }

    public List findList() {
        return super.findList("userName");
    }
    
    public Page findList(PageParam pageParam, List roleIds) {
//        DetachedCriteria dc = super.getDetachedCriteria();
//        super.getQuery("");
        
//        DetachedCriteria dcRoles = dc.createCriteria("roles");
//        dcRoles.add(Restrictions.not(Restrictions.in("idStr", roleIds)));
        
//        Junction or = Restrictions.disjunction();
//        or.add(Restrictions.sizeEq("roles", 0));
        
//        or.add(or);
        
//        dc.add(Restrictions.or(Restrictions.sizeEq("roles", 0), Restrictions.not(Restrictions.in("roles.idStr", roleIds))));
        
        String hql = "from User usr where usr.roles.size = 0";
        
        return super.findPage(hql, null, pageParam, null);
        
//        return super.findPage(dc, pageParam);
    }

    public List findList(User example) {
        return super.findList(getFindListCriteria(example));
    }
    
    public Page findList(PageParam pageParam, User example) {
        DetachedCriteria dc = getFindListCriteria(example);
        return super.findPage(dc, pageParam);
        ///
    }

    public DetachedCriteria getFindListCriteria(User example) {
        DetachedCriteria dc = super.getDetachedCriteria();
        if (StringUtils.isNotEmpty(example.getUserName())) {
            dc.add(Restrictions.like("userName", example.getUserName(),MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(example.getEmail())) {
            dc.add(Restrictions.like("email", example.getEmail(),MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(example.getRealName())) {
            dc.add(Restrictions.like("realName", example.getRealName(),MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(example.getUserStatus())) {
            dc.add(Restrictions.eq("userStatus", example.getUserStatus()));
        }
        if (example.getOrganizations().size() > 0) {
            DetachedCriteria dcOrg = dc.createCriteria("organizations");
            
            List idStrs = new ArrayList();
            List orgs = example.getOrganizations();
            for (Iterator iterator = orgs.iterator(); iterator.hasNext();) {
                Organization org = (Organization) iterator.next();
                
                idStrs.add(org.getIdStr().trim());
            }
            
            dcOrg.add(Restrictions.in("idStr", idStrs));;
        }
        
        dc.addOrder(Order.asc("userName"));
        
        
        return dc;
    }

    public User findById(String id) {
        return (User) super.findById(id);
    }
    
    public User findByUniqueUserName(String userName) {
        DetachedCriteria dc = super.getDetachedCriteria();
        dc.add(Restrictions.eq("userName", userName));
        
        List list = super.findList(dc);
        if (list.size() == 0) {
            return null;
        }
        
        return (User)list.get(0);
    }
    
    public List findUserList() {
        DetachedCriteria dc = super.getDetachedCriteria();
        dc.addOrder(Order.asc("idStr"));
        
        return super.findList(dc);
    }
}