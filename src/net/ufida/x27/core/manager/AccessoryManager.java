
package net.ufida.x27.core.manager;

import java.util.Calendar;

import net.ufida.x27.core.model.Accessory;
import net.ufida.x27.util.hibernate.BaseManager;

/**
 * @author qinzhiyong  2008-3-19
 *
 * 
 */
public class AccessoryManager extends BaseManager {
    
    public Accessory save(Accessory entity) {
        entity.setCreateTime(Calendar.getInstance());
        super.save(entity);
        return entity;
    }

    public Class getModelClass() {
        return Accessory.class;
    }
    
    public Accessory findById(String id) {
        return (Accessory)super.findById(id);
    }
}
