package net.ufida.x27.core.model;

import java.util.LinkedList;
import java.util.List;

import net.ufida.x27.util.hibernate.BaseModel;

/**
 * @hibernate.class table="TB_PRIVILEGE" dynamic-insert="true" dynamic-update="true"
 * 
 */
public class Privilege extends BaseModel {
    
    /**@hibernate.id column="privil_id" generator-class="uuid" length="32" type="string"
     */
    private String idStr;
    
    /**@hibernate.property column="privil_name" length="50" type="string" not-null="true" unique="true"
     */
    private String privilName;
    
    /**@hibernate.property column="category" length="50" type="string" not-null="true" 
     */
    private String category;
    
    /**@hibernate.property column="pattern" length="255" type="string" not-null="true" unique="true"
     */
    private String pattern;
    
    /**@hibernate.property column="type" length="50" type="string" not-null="true" 
     */
    private String type;
    
    /**@hibernate.property column="dynamic_rule" length="255" type="string"
     */
    private String rule;
    
    /**@hibernate.bag cascade="save-update" table="TR_ROLE_PRI"
     * @hibernate.key column="PRIVIL_ID"
     * @hibernate.many-to-many class="net.gbicc.x27.core.model.Role" column="ROLE_ID"
     */
    private List roles=new LinkedList();
    
    public String getPattern() {
        return pattern;
    }
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
    public String getIdStr() {
        return idStr;
    }
    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }
    public String getPrivilName() {
        return privilName;
    }
    public void setPrivilName(String privilName) {
        this.privilName = privilName;
    }
    public String getRule() {
        return rule;
    }
    public void setRule(String rule) {
        this.rule = rule;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Privilege(String privilId, String privilName, String pattern, String type, String rule) {
        this.idStr = privilId;
        this.privilName = privilName;
        this.pattern = pattern;
        this.type = type;
        this.rule = rule;
    }
    public Privilege() {
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public List getRoles() {
        return roles;
    }
    public void setRoles(List roles) {
        this.roles = roles;
    }  
    
}