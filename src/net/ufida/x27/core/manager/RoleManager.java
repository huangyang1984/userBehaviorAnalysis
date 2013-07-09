package net.ufida.x27.core.manager;

import java.util.LinkedList;
import java.util.List;

import net.ufida.x27.core.model.Role;
import net.ufida.x27.exception.X27Exception;
import net.ufida.x27.util.hibernate.BaseManager;

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
public class RoleManager extends BaseManager {

    public Class getModelClass() {
        return Role.class;
    }

    public void updateBasicInfo(Role param) {
        //唯一性判断
        List uniquePropertyNames = new LinkedList();
        uniquePropertyNames.add("roleName");
        super.isUnique(true, param, uniquePropertyNames, X27Exception.role_name_has_exist());

        param.setPrivileges(null);
        param.setUsers(null);
        super.updateByParam(param);
    }

    public List findList() {
        return super.findList("roleName");
    }

    public List findList(Role example) {
        DetachedCriteria dc = super.getDetachedCriteria();
        if (StringUtils.isNotEmpty(example.getRoleName())) {
            dc.add(Restrictions.like("roleName", example.getRoleName(), MatchMode.ANYWHERE));
        }
        dc.addOrder(Order.asc("roleName"));
        return super.findList(dc);
    }

    public Role findById(String id) {
        return (Role) super.findById(id);
    }

    public boolean isRoleNameExsits(String roleName) {
        DetachedCriteria dc = super.getDetachedCriteria();
        dc.add(Restrictions.eq("roleName", roleName));

        return (super.findList(dc).size() > 0);
    }

    public void save(Role role) {
        //唯一性判断
        List uniquePropertyNames = new LinkedList();
        uniquePropertyNames.add("roleName");
        super.isUnique(true, role, uniquePropertyNames, X27Exception.role_name_has_exist());

        super.save(role);
    }
}
