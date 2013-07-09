package net.ufida.x27.core.manager;

import net.ufida.x27.core.model.AccessoryContent;
import net.ufida.x27.util.hibernate.BaseManager;

/**
 * 
 * @author Steven.yang
 *
 */
public class AccessoryContentManager extends BaseManager {
    
    public AccessoryContent save(byte[] content) {
        AccessoryContent entity = new AccessoryContent();
        entity.setContent(content);
        super.save(entity);
        return entity;
    }

    public AccessoryContent findById(String id) {
        return (AccessoryContent) super.findById(id);
    }
    
    public Class getModelClass() {
        return AccessoryContent.class;
    }

}
