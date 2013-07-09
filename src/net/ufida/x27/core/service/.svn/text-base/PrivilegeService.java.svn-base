package net.ufida.x27.core.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import net.ufida.x27.core.model.Privilege;

public interface PrivilegeService {
    
    List findListByExample(Privilege example) ;
    
    Map findAllSortByCategory() ;
    
    Privilege findById(String id) ;
    
    void deleteById(String id) ;
    
    void deleteByIdList(Collection ids) ;
    
    void save(Privilege privilege);
    
    void update(Privilege param);

    List findAll();
    
    boolean isExsitsByPrivilNameOrPattern(String privilName, String pattern);
    
    boolean hasRoleByIdList(Collection list);
}
