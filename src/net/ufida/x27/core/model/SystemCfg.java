package net.ufida.x27.core.model;

import net.ufida.x27.util.hibernate.BaseModel;

/**系统参数表
 * @hibernate.class table="TB_SYSTEM_CFG" schema="tcrcb" dynamic-insert="true" dynamic-update="true"
 */
public class SystemCfg extends BaseModel {

    /**@hibernate.id column="system_cfg_id" generator-class="uuid" length="32" type="string"
     */
    private String idStr;
    
    /**字段名
     * @hibernate.property column="name" length="50" type="string" not-null="true" unique="true"
     */
    private String name;
    
    /**值
     * @hibernate.property column="value" length="50" type="string" not-null="true"
     */
    private String value;
    
    public SystemCfg() {
    }

    public SystemCfg(String idStr) {
        this.idStr = idStr;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    } 


}
