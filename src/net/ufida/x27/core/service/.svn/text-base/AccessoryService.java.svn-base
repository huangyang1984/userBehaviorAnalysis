package net.ufida.x27.core.service;

import net.ufida.x27.core.model.Accessory;


/**
 *
 */
public interface AccessoryService {
    
    /**保存一个附件到数据库
     * @param fileName 文件名称
     * @param content 附件内容
     * @return 保存后带id的Accessory对象
     */
    Accessory save(String fileName, byte[] content);
    
    /**保存一个附件到数据库
     * @param fileName 文件名称
     * @param content 附件内容
     * @param uuid 相关业务表id，适合1个对象有多个附件的情况，可以为null
     * @return 保存后带id的Accessory对象
     */
    Accessory save(String fileName, byte[] content, String uuid);
    
    Accessory findById(String id);
    
}
