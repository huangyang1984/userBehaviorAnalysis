package net.ufida.x27.core.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.ufida.x27.util.hibernate.BaseModel;

/**
 * @hibernate.class table="TB_ROLES" schema="tcrcb" dynamic-insert="true" dynamic-update="true"
 * 
 */
public class Role extends BaseModel {
    
    /**@hibernate.id column="role_id" generator-class="uuid" length="32" type="string"
     */
    private String idStr; 
    
    /**
     * @hibernate.property column="role_name" length="255" type="string" not-null="true" unique="true"
     */
    private String roleName; 
    
    /**@hibernate.property column="description" length="255" type="string"
     */
    private String description; 
    
    /**@hibernate.bag cascade="save-update" table="TR_USER_ROLE" schema="tcrcb" inverse="true"
     * @hibernate.key column="ROLE_ID"
     * @hibernate.many-to-many class="net.gbicc.x27.core.model.User" column="PK_ID"
     */
    private List users = new LinkedList();
    
    /**@hibernate.bag cascade="save-update" table="TR_ROLE_PRI" schema="tcrcb"
     * @hibernate.key column="ROLE_ID"
     * @hibernate.many-to-many class="net.gbicc.x27.core.model.Privilege" column="PRIVIL_ID"
     */
    private List privileges = new LinkedList();
    
    public void addPrivilege (Privilege privilege) {
        if (privilege != null && !getPrivileges().contains(privilege)) {
            this.getPrivileges().add(privilege);
        }
    }
    
    public void removePrivilege (Privilege privilege) {
        if (privilege != null) {
            getPrivileges().remove(privilege);
        }
    }
    
    public void addUser(User user) {
        if (user != null && !user.getRoles().contains(this) && !getUsers().contains(user)) {
            user.getRoles().add(this);
            //this.getUsers().add(user);
        }
    }
    
    public void removeUser(User user) {
        if (user != null) {
            user.getRoles().remove(this);
            getUsers().remove(user);
        }
    }
    
    public boolean hasPrivilege(String privilId) {
        for (Iterator it = privileges.iterator(); it.hasNext();) {
            Privilege privilege = (Privilege) it.next();
            if (privilege.getIdStr().equals(privilId)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasUser(String userId) {
        for (Iterator it = users.iterator(); it.hasNext();) {
            User user = (User) it.next();
            if (user.getIdStr().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    public List getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List privileges) {
        this.privileges = privileges;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
