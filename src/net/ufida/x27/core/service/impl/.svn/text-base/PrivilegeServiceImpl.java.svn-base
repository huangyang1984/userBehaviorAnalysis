package net.ufida.x27.core.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ufida.x27.core.manager.PrivilegeManager;
import net.ufida.x27.core.model.Privilege;
import net.ufida.x27.core.service.PrivilegeService;

import org.apache.log4j.Logger;

public class PrivilegeServiceImpl implements PrivilegeService {
    private static final Logger log = Logger.getLogger(PrivilegeServiceImpl.class);
    private PrivilegeManager privilegeManager ;

    public void deleteById(String id) {
        privilegeManager.deleteById(id);
    }

    public Privilege findById(String id) {
        return privilegeManager.findById(id);
    }
    
    public List findRolesByPrivilegeId(String privilegeId) {
        return privilegeManager.findById(privilegeId).getRoles();
    }

    public List findListByExample(Privilege example) {
        return privilegeManager.findList(example);
    }
    
    public boolean isExsitsByPrivilNameOrPattern(String privilName, String pattern) {
        return privilegeManager.isExsitsByPrivilNameOrPattern(privilName, pattern);
    }

    public void save(Privilege privilege) {
//        Privilege example = new Privilege();
//        example.setPrivilName(privilege.getPrivilName());
//        if (findListByExample(example).size() != 0) {
//            throw new X27Exception(X27Exception.PRIVILNAME_HAS_EXIST);
//        }
        
        privilegeManager.save(privilege);
    }

    public void update(Privilege param) {
        privilegeManager.updatePrivilege(param);
    }

    public Map findAllSortByCategory() {
        return privilegeManager.findAllSortByCategory();
    }

    public void setPrivilegeManager(PrivilegeManager privilegeManager) {
        this.privilegeManager = privilegeManager;
    }

    public void deleteByIdList(Collection ids) {
        privilegeManager.deleteByIdList(ids);
    }
    
    public boolean findBindRoleListByPrivilegeId(String privilegeId) {
        log.info("privilegeId:" + privilegeId);
        List bindList = this.findRolesByPrivilegeId(privilegeId);
        log.info("bindList:" + bindList.size());
        return bindList.size()>0;
    }
    
    public boolean hasRoleByIdList(Collection list) {
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            if (findBindRoleListByPrivilegeId((String) iterator.next())) {
                return true;
            }
        }
        
        return false;
    }

    public List findAll() {
        
        return privilegeManager.findList();
    }
    
}
