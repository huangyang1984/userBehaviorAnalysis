package net.ufida.x27.core.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.ufida.x27.util.hibernate.BaseModel;

import org.apache.commons.lang.StringUtils;

/**
 * @hibernate.class table="TB_ORGANIZATION" schema="tcrcb" dynamic-insert="true" dynamic-update="true"
 */
public class Organization extends BaseModel {
    
    /**@hibernate.id column="org_id" generator-class="uuid" length="32" type="string"
     */
    private String idStr;

    /**机构名称
     * @hibernate.property column="org_name" length="50" type="string" not-null="true" unique="true"
     */
    private String orgName;
    
    /**简称
     * @hibernate.property column="org_short_name" length="50" type="string"
     */
    private String orgShortName;
    
    /**机构码
     * @hibernate.property column="org_code" length="50" type="string" not-null="true" unique="true"
     */
    private String orgCode;
    
    /**备注
     * @hibernate.property column="memo" length="255" type="string"
     */
    private String memo;
    
    /**机构类型
     * @hibernate.property column="ORG_TYPE" length="4" type="string"
     */
    private String orgType;

    /**@hibernate.bag cascade="save-update" table="TR_USER_ORG" schema="tcrcb" inverse="true" lazy="true"
     * @hibernate.key column="ORG_ID"
     * @hibernate.many-to-many class="net.gbicc.x27.core.model.User" column="PK_ID"
     */
    private List users = new LinkedList();

    /**@hibernate.many-to-one column="FK_PARENT_ORG_ID" class="net.gbicc.x27.core.model.Organization"
     */
    private Organization parentOrganization;

    /**@hibernate.bag cascade="save-update" inverse="true"  order-by="ORG_NAME"
     * @hibernate.key column="FK_PARENT_ORG_ID" 
     * @hibernate.one-to-many class="net.gbicc.x27.core.model.Organization" 
     */
    private List childOrgs = new LinkedList();
    
    private String parentOrgsString;
    
    public Organization() {
    }
    
    public Organization(String idStr) {
        this.idStr = idStr;
    }
    
    public List getChildOrgs() {
        return childOrgs;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getIdStr() {
        return idStr;
    }

    public String getMemo() {
        return memo;
    }

    public Organization getParentOrganization() {
        return parentOrganization;
    }

    public List getUsers() {
        return users;
    }

    public void setChildOrgs(List childDepartments) {
        this.childOrgs = childDepartments;
    }

    public void setOrgName(String departName) {
        this.orgName = departName;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public void setParentOrganization(Organization parentOrganization) {
        this.parentOrganization = parentOrganization;
    }

    public void setUsers(List users) {
        this.users = users;
    }

    public void addChildOrg(Organization child) {
        if (child != null) {
            child.setParentOrganization(this);
            if (!getChildOrgs().contains(child)) {
                this.getChildOrgs().add(child);
            }
        }
    }

    public void addMember(User user) {
        if (user != null && !user.getOrganizations().contains(this) && !getUsers().contains(user)) {
            user.getOrganizations().add(this);
            this.getUsers().add(user);
        }
    }

    public void removeMember(User user) {
        if (user != null) {
            user.getOrganizations().remove(this);
            getUsers().remove(user);
        }
    }

    public void clear() {
        for (Iterator it = getUsers().iterator(); it.hasNext();) {
            User user = (User) it.next();
            user.getOrganizations().remove(this);
        }
        getUsers().clear();

        for (Iterator it = this.getChildOrgs().iterator(); it.hasNext();) {
            Organization org = (Organization) it.next();
            org.setParentOrganization(null);
        }
        getChildOrgs().clear();

        if (getParentOrganization() != null) {
            this.getParentOrganization().clear();
        }
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgShortName() {
        return orgShortName;
    }

    public void setOrgShortName(String orgShortName) {
        this.orgShortName = orgShortName;
    }
    
    public String getOrgNameAndOrgIdAndHasChild() {
        String tar = this.getOrgName()+"|"+this.getIdStr()+"|"+hasChildOrg();
        return tar;
    }
    
    public String getParentOrgsString() {
        return parentOrgsString;
    }
    
    /**
     * 初始化父节点列表名称 <递归>
     */
    public String genParentOrgsString() {
        StringBuffer tar = new StringBuffer("");
        Organization parent = getParentOrganization();
        if (parent == null) {
            parentOrgsString = "";
            return "";
        }
        String parent_parentOrgsString = parent.genParentOrgsString();
        if (StringUtils.isNotEmpty(parent_parentOrgsString)) {
            tar.append(parent_parentOrgsString + "\\");
        }
        tar.append(parent.getOrgName());
        parentOrgsString = tar.toString();
        return parentOrgsString;
    }
    
    public boolean hasChildOrg() {
        if(this.getChildOrgs().size()>0)
            return true;
        else
            return false;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
    
}
