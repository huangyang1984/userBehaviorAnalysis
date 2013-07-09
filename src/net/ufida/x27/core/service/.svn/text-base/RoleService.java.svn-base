package net.ufida.x27.core.service;

import java.util.Collection;
import java.util.List;

import net.ufida.x27.core.model.Role;
import net.ufida.x27.util.web.PageParam;

public interface RoleService {
    
    List findAllRoles();
    
    List findRolesByExample(Role example);
    
    Role findById(String id) ;
    
    void save(Role role) ;
    
    void deleteByIdList(Collection list);
    
    void deleteById(String id) ;
    
    void updateBasicInfo(Role param);
    
    void authorizationRole(String roleId , String[]privilIds);
    
    void authorizationUser(String roleId, String[] userIds);
    
    List findNotBindUserListByRoleId (String roleId);
    
    List findNotBindUserListByRoleId(PageParam pageParam, String roleId);

    void addRoleUser(String parameter, String[] idArray);

    void delRoleUser(String parameter, String[] idArray);
    
    boolean isRoleNameExsits(String roleName);
    
    boolean findBindUserListByRoleId(String roleId);
    
    boolean hasUserByIdList(Collection list);
}
