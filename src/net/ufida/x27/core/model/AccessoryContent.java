package net.ufida.x27.core.model;

import net.ufida.x27.util.hibernate.BaseModel;
/**
 * @hibernate.class table="x27_accessory_content" schema="tcrcb" dynamic-update="true"
 * 
 */
public class AccessoryContent extends BaseModel {
    /**@hibernate.id column="accessory_content_id" generator-class="uuid" type="string" length="32"
     */
    private String idStr;
    
    /**@hibernate.property column="content" type="binary" not-null="true" 
     */
    private byte[] content;
    
    
    public AccessoryContent() {
    }
    
    public AccessoryContent(String idStr) {
       this.idStr = idStr;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

}
