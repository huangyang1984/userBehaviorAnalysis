package net.ufida.x27.core.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.ufida.x27.util.hibernate.BaseModel;

/**
 * @hibernate.class table="TB_USER" schema="tcrcb" dynamic-insert="true" dynamic-update="true"
 * @author liyingquan 2007-8-6
 * 
 */
public class User extends BaseModel {
    
    /**@hibernate.id column="PK_ID" generator-class="uuid" length="32" type="string"
     */
    private String idStr;

    /**@hibernate.property column="USER_NAME" length="255" type="string" not-null="true" unique="true"
     */
    private String userName;

    /**@hibernate.property column="PWD" length="255" type="string" not-null="true"
     */
    private String password;

    /**@hibernate.property column="EMAIL" length="50" type="string" 
     */
    private String email;

    /**@hibernate.property column="REAL_NAME" length="50" type="string"
     */
    private String realName;
    
    /**@hibernate.property column="SEX" length="2" type="string"
     */
    private String sex;
    
    /**@hibernate.property column="BIRTH_DATE"  type="calendar" 
     */
    private Calendar birthDate;

    /**@hibernate.property column="last_login_ip" length="50" type="string"
     */
    private String lastLoginIp;
    
    /**@hibernate.property column="last_login_time" type="timestamp"
     */
    private Date lastLoginTime;
    
    /**0表示冻结，1表示正常
     * @hibernate.property column="USER_STATUS" length="1" type="string"
     */
    private String userStatus;
    
    /**
     * @hibernate.bag cascade="save-update" table="TR_USER_ORG" schema="tcrcb" lazy="true"
     * @hibernate.key column="PK_ID"
     * @hibernate.many-to-many class="net.gbicc.x27.core.model.Organization" column="ORG_ID"
     */
    private List organizations = new LinkedList();
    
    /**
     * @hibernate.bag cascade="save-update" table="TR_USER_ROLE" schema="tcrcb"
     * @hibernate.key column="PK_ID"
     * @hibernate.many-to-many class="net.gbicc.x27.core.model.Role" column="ROLE_ID"
     */
    private List roles = new LinkedList();
    
    /**@hibernate.property column="START_DATE"  type="calendar" 
     */
    private Calendar startDate;
    
    /**@hibernate.property column="TERMINATE_DATE"  type="calendar" 
     */
    private Calendar terminateDate;
    
    /**@hibernate.property column="PRIVILEGE" length="2" type="string" 
     */
    private String privilege;
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getTerminateDate() {
        return terminateDate;
    }

    public void setTerminateDate(Calendar terminateDate) {
        this.terminateDate = terminateDate;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public User() {
    }
    
    public User(String idStr) {
        this.idStr = idStr;
    }
    
    public List findRoleIds() {
        List roleIds = new LinkedList();
        if (getRoles() == null) {
            return roleIds;
        }
        for (Iterator iterator = getRoles().iterator(); iterator.hasNext();) {
            Role role = (Role) iterator.next();
            roleIds.add(role.getIdStr());
        }
        return roleIds;
    }
    
    public boolean hasRole(String roleId) {
        for (Iterator it = roles.iterator(); it.hasNext();) {
            Role role = (Role) it.next();
            if (role.getIdStr().equals(roleId)) {
                return true;
            }
        }
        return false;
    }
    public void addRole(Role role) {
        if (role != null) {
            this.getRoles().add(role);
        }
    }
    
    public void removeRole(Role role) {
        if (role != null) {
            role.getUsers().remove(this);
            getRoles().remove(role);
        }
    }
    
    public void addOrg(Organization org) {
        if (org != null && !org.getUsers().contains(this) && !getOrganizations().contains(org)) {
//            org.getUsers().add(this);
            this.getOrganizations().add(org);
        }
    }
    public String getEmail() {
        return email;
    }

    public String getIdStr() {
        return idStr;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List getOrganizations() {
        return organizations;
    }
    
    public String getOrgShortNames() {
        String orgShorNames = "";
        int i = 0;
        
        for (Iterator iterator = organizations.iterator(); iterator.hasNext(); ++i) {
            Organization org = (Organization) iterator.next();
            if (i == 0) {
                orgShorNames = org.getOrgShortName();
                continue;
            }
            
            orgShorNames = orgShorNames + "," + org.getOrgShortName();
        }
        
        return orgShorNames;
    }
    
    public String getOrgIds() {
        String orgIds = "";
        int i = 0;
        for (Iterator iterator = organizations.iterator(); iterator.hasNext(); ++i) {
            Organization org = (Organization) iterator.next();
            if (i == 0) {
                orgIds = org.getIdStr();
                continue;
            }
            
            orgIds = orgIds + "," + org.getIdStr();
        }
        
        return orgIds;
    }

    public void setOrganizations(List organizations) {
        this.organizations = organizations;
    }

    public boolean isInOrg(Organization org) {
        return org != null && org.getUsers().contains(this) && this.getOrganizations().contains(org);
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }
    public String getLastLoginIp() {
        return lastLoginIp;
    }
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    
}