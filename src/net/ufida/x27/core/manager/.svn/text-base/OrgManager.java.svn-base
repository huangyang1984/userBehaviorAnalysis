package net.ufida.x27.core.manager;

import java.util.Collection;
import java.util.List;

import net.ufida.x27.core.model.Organization;
import net.ufida.x27.util.hibernate.BaseManager;
import net.ufida.x27.util.hibernate.ModelUtils;

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
public class OrgManager extends BaseManager {
    
    public Class getModelClass() {
        return Organization.class;
    }
    
    public void save(String parentOrgName, Organization org) {
        Organization parentOrg = findByOrgName(parentOrgName);
        org.setParentOrganization(parentOrg);
        super.save(org);
    }

    public void updateOrgByParam(String parentOrgName, Organization param) {
        Organization org = findById(param.getIdStr());
        param.setChildOrgs(null);
        param.setParentOrganization(null);
        ModelUtils.transferValue(param, org);
        Organization parentOrg = findByOrgName(parentOrgName);
        org.setParentOrganization(parentOrg);
        super.update(org);
    }

    public void addChild(String orgId, Organization child) {
        Organization org = findById(orgId);
        org.addChildOrg(child);
        super.update(org);
    }

    public void deleteById(String id) {
        Organization org = findById(id);
        org.clear();
        super.delete(org);
    }

    public Organization findByOrgName(String orgName) {
        Organization example = new Organization();
        example.setOrgName(orgName);
        return (Organization) super.findUniqueResult(getFindListCriteria(example));
    }

    public List findTopLevelOrgs() {
        DetachedCriteria dc = super.getDetachedCriteria();
        dc.add(Restrictions.isNull("parentOrganization"));
        return findList(dc);
    }
    
    public List findList() {
        return super.findList("orgName");
    }
    
    public List findListFrmRoot() {
        DetachedCriteria dc = super.getDetachedCriteria();
        dc.add(Restrictions.eq("orgType", "0000"));
        
        return findList(dc);
    }

    public List findList(Organization example) {
        return super.findList(getFindListCriteria(example));
    }

    public DetachedCriteria getFindListCriteria(Organization example) {
        DetachedCriteria dc = super.getDetachedCriteria();
        if (StringUtils.isNotEmpty(example.getOrgName())) {
            dc.add(Restrictions.like("orgName", example.getOrgName(), MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotEmpty(example.getOrgCode())) {
            dc.add(Restrictions.like("orgCode", example.getOrgCode(), MatchMode.ANYWHERE));
        }
        dc.addOrder(Order.asc("orgName"));
        return dc;
    }

    public Organization findById(String id) {
        return (Organization) super.findById(id);
    }

    public List findList(DetachedCriteria dc) {
        //dc.addOrder(Order.asc("orgName"));
        return super.findList(dc);
    }
    
    public Organization findByOrgCode(String orgCode) {
        Organization example = new Organization();
        example.setOrgCode(orgCode);
        
        return (Organization) super.findUniqueResult(getFindListCriteria(example));
    }
    
    public List findOrgTopList(String orgCode) {
        DetachedCriteria dc = super.getDetachedCriteria();
        log.info("orgCode = "+ orgCode);
//        log.info("706640124".equals(orgCode.trim()));
        if(!"706640124".equals(orgCode.trim())) {
            dc.add(Restrictions.eq("orgCode", orgCode.trim()));
        }
        dc.addOrder(Order.asc("orgCode"));
        
        return super.findList(dc);
    }

    public void deleteOrgs(Collection idList) {
        super.deleteByIdList(idList);
    }
}