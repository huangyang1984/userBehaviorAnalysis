package net.ufida.x27.dict.manager;

import java.util.List;

import net.ufida.x27.dict.model.Enums;
import net.ufida.x27.util.hibernate.BaseManager;
import net.ufida.x27.util.hibernate.ManagerUtils;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EnumManager extends BaseManager {
    
    public Class getModelClass() {
        return Enums.class;
    }
    
    public Enums findById(String id) {
        return (Enums) findById(id);
    }

    public Enums findByCode(String code) {
        Enums example = new Enums();
        example.setCode(code);
        return (Enums) super.findUniqueResult(getFindListCriteria(example));
    }
    
    public List findList(Enums example) {
        return findList(getFindListCriteria(example));
    }

    public DetachedCriteria getFindListCriteria(Enums example) {
        DetachedCriteria dc = ManagerUtils.getCriteriaByExample(example);
        if (example.getDict() != null) {
            dc.add(Restrictions.eq("dict.code", example.getDict().getCode()));
        }
        dc.addOrder(Order.asc("code"));
        return dc;
    }

}
