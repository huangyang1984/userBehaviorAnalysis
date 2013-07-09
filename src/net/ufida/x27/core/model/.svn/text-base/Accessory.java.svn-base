package net.ufida.x27.core.model;

import java.util.Calendar;

import net.ufida.x27.util.hibernate.BaseModel;
/**
 * @hibernate.class table="x27_accessory" schema="tcrcb" dynamic-update="true"
 */
public class Accessory extends BaseModel {
    
    /**@hibernate.id column="accessory_id" generator-class="uuid" type="string" length="32" 
     */
    private String idStr;
    
    /**相关业务表id
     * @hibernate.property column="uuid" type="string" length="32"
     */
    private String uuid;
    
    /**文件名称
     * @hibernate.property column="file_name" type="string" length="255" not-null="true"
     */
    private String fileName;
    
    /**创建时间
     * @hibernate.property column="create_time" type="calendar" length="32" not-null="true"
     */
    private Calendar createTime;
    
    /**文件大小
     * @hibernate.property column="file_size" type="long" length="32" not-null="true"
     */
    private Long fileSize;
    
    /**附件内容对象
     * @hibernate.many-to-one column="accessory_content_id" not-null="true"
     *                        class="net.gbicc.x27.core.model.AccessoryContent"
     */
    private AccessoryContent accessoryContent;

    public Accessory() {
    }

    public Accessory(String idStr) {
        this.idStr = idStr;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    public AccessoryContent getAccessoryContent() {
        return accessoryContent;
    }

    public void setAccessoryContent(AccessoryContent accessoryContent) {
        this.accessoryContent = accessoryContent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

}
