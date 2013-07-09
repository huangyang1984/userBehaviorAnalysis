package net.ufida.x27.dict.model;

import net.ufida.x27.util.hibernate.BaseModel;


/**
 * @hibernate.class table="TB_COMMON_ENUM" dynamic-insert="true" dynamic-update="true"
 */
public class Enums extends BaseModel {
    
    /**@hibernate.id column="enum_id" generator-class="uuid" length="32" type="string"
     */
    private String idStr;
    
    /**@hibernate.property column="code" length="9" type="string" not-null="true" unique="true"
     */
    private String code;
    
    
    /**@hibernate.many-to-one column="dict_id" class="net.gbicc.x27.dict.model.Dict" not-null="true"
     */
    private Dict dict;
    
    /**@hibernate.property column="value" length="60" type="string" not-null="true"
     */
    private String value;
    
    /**@hibernate.property column="memo" length="200" type="string" not-null="true"
     */
    private String memo;
    
    public Enums() {
    }
    
    public Enums(String idStr) {
        this.idStr = idStr;
    }
    
    public Enums(String code, Dict dict, String value, String memo) {
        this.code = code;
        this.dict = dict;
        this.value = value;
        this.memo = memo;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Dict getDict() {
        return dict;
    }
    public void setDict(Dict dict) {
        this.dict = dict;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getIdStr() {
        return idStr;
    }
    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }
}
