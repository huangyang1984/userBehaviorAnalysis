package net.ufida.x27.dict.manager;

import java.util.List;

import net.ufida.x27.dict.model.Dict;
import net.ufida.x27.exception.X27Exception;
import net.ufida.x27.util.hibernate.BaseManager;
import net.ufida.x27.util.hibernate.ManagerUtils;
import net.ufida.x27.util.hibernate.ModelUtils;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DictManager extends BaseManager {
    
    public Class getModelClass() {
        return Dict.class;
    }
    
    public Dict findByCode(String code) {
        Dict example = new Dict();
        example.setCode(code);
        return (Dict) super.findUniqueResult(getFindListCriteria(example, false));
    }
    
    public Dict findByName(String name) {
        Dict example = new Dict();
        example.setName(name);
        return (Dict) super.findUniqueResult(getFindListCriteria(example, false));
    }
    
    public List findList(String code, String name) {
        DetachedCriteria dc = super.getDetachedCriteria();
        if (StringUtils.isNotEmpty(code)) {
            dc.add(Restrictions.eq("code", code));
        }
        if (StringUtils.isNotEmpty(name)) {
            dc.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
        }
        return super.findList(dc);
    }

    public List findList(Dict example) {
        return findList(example, false);
    }
    
    public List findList(Dict example, boolean isLike) {
        return super.findList(getFindListCriteria(example, isLike));
    }
    
    public DetachedCriteria getFindListCriteria(Dict example, boolean isLike) {
        DetachedCriteria dc = ManagerUtils.getCriteriaByExample(example, isLike);
        dc.addOrder(Order.asc("code"));
        return dc;
    }
    
    public Dict findById(String id) {
        return (Dict) super.findById(id);
    }

    public void save(Dict param) {
        param.checkEnumList();
        checkCodeAndName(param, false);
        super.save(param);
    }

    public void updateByParam(Dict param) {
        param.checkEnumList();
        checkCodeAndName(param, true);
        Dict entity = findById(param.getIdStr());
        boolean hadChangeDictCode = !entity.getCode().equals(param.getCode());
        ModelUtils.transferValue(param, entity);
        /*如果dictCode变更，枚举的前缀要一起更新*/
        if (hadChangeDictCode) {
            entity.updateNewDictCode();
        }
        super.updateByParam(param);
    }
    
    private void checkCodeAndName(Dict param, boolean forUpdate) {
        DetachedCriteria dc4Code = super.getDetachedCriteria();
        dc4Code.add(Restrictions.eq("code", param.getCode()));
        DetachedCriteria dc4Name = super.getDetachedCriteria();
        dc4Name.add(Restrictions.eq("name", param.getName()));
        //当修改时，要排除自己进行判断
        if (forUpdate) {
            dc4Code.add(Restrictions.ne("idStr", param.getIdStr()));
            dc4Name.add(Restrictions.ne("idStr", param.getIdStr()));
        }
        if (super.findList(dc4Code).size() > 0) {
            throw X27Exception.dict_code_exist();
        }
        if (super.findList(dc4Name).size() > 0) {
            throw X27Exception.dict_name_exist();
        }
    }

}
