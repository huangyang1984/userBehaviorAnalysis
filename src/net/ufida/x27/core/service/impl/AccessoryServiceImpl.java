package net.ufida.x27.core.service.impl;

import net.ufida.x27.core.manager.AccessoryContentManager;
import net.ufida.x27.core.manager.AccessoryManager;
import net.ufida.x27.core.model.Accessory;
import net.ufida.x27.core.service.AccessoryService;

import org.apache.log4j.Logger;

/**
 * @author 吴斌 2008-3-24
 *
 */
public class AccessoryServiceImpl implements AccessoryService {
    
    private static final Logger log = Logger.getLogger(AccessoryServiceImpl.class);
    
    private AccessoryManager accessoryManager;
    
    private AccessoryContentManager accessoryContentManager;

    public Accessory save(String fileName, byte[] content) {
        return save(fileName, content, null);
    }

    public Accessory save(String fileName, byte[] content, String uuid) {
        Accessory accessory = new Accessory();
        accessory.setUuid(uuid);
        accessory.setFileName(fileName);
        accessory.setFileSize(new Long(content.length));
        accessory.setAccessoryContent(accessoryContentManager.save(content));
        return accessoryManager.save(accessory);
    }

    public Accessory findById(String id) {
        return accessoryManager.findById(id);
    }

    public void setAccessoryManager(AccessoryManager accessoryManager) {
        this.accessoryManager = accessoryManager;
    }

    public void setAccessoryContentManager(AccessoryContentManager accessoryContentManager) {
        this.accessoryContentManager = accessoryContentManager;
    }

}
