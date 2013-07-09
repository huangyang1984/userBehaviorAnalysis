package net.ufida.x27.core.manager;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.ufida.x27.core.model.Privilege;
import net.ufida.x27.exception.X27Exception;
import net.ufida.x27.util.hibernate.BaseManager;
import net.ufida.x27.util.hibernate.ModelUtils;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * 
 * @author Steven.yang
 *
 */
public class PrivilegeManager extends BaseManager {

    public Class getModelClass() {
        return Privilege.class;
    }

    public void save(Privilege privilege) {
        //唯一性判断
        List uniquePropertyNames = new LinkedList();
        uniquePropertyNames.add("privilName");
        super.isUnique(true, privilege, uniquePropertyNames, X27Exception.privil_name_has_exist());

        super.save(privilege);
    }

    public void updatePrivilege(Privilege param) {
        /*
         * Privilege entity = findById(param.getIdStr()); Privilege example = new Privilege();
         * example.setPrivilName(param.getPrivilName()); if ((!entity.getPrivilName().equals(param.getPrivilName())) &&
         * (super.findListByExample(example).size() != 0)) { throw new X27Exception(X27Exception.PRIVILNAME_HAS_EXIST); }
         */
        //唯一性判断
        List uniquePropertyNames = new LinkedList();
        uniquePropertyNames.add("privilName");
        super.isUnique(true, param, uniquePropertyNames, X27Exception.privil_name_has_exist());

        super.updateByParam(param);
    }

    public Map findAllSortByCategory() {
        return ModelUtils.list2MapWithListValue(super.findList(), "category");
    }

    public Privilege findById(String id) {
        return (Privilege) super.findById(id);
    }

    public List findList(Privilege example) {
        DetachedCriteria dc = super.getDetachedCriteria();
        Criteria criteria = getSession().createCriteria(Privilege.class);
        if (StringUtils.isNotEmpty(example.getPrivilName())) {
            dc.add(Restrictions.like("privilName", example.getPrivilName(), MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(example.getPattern())) {
            dc.add(Restrictions.like("pattern", example.getPattern(), MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(example.getType())) {
            dc.add(Restrictions.eq("type", example.getType()));
        }
        dc.addOrder(Order.asc("privilName"));
        return super.findList(dc);
    }

    public boolean isExsitsByPrivilNameOrPattern(String privilName, String pattern) {
        DetachedCriteria dc = super.getDetachedCriteria();
        dc.add(Restrictions.or(Restrictions.eq("privilName", privilName), Restrictions.eq("pattern", pattern)));

        return super.findList(dc).size() > 0;
    }
}
