package net.ufida.x27.core.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.ufida.x27.core.manager.PrivilegeManager;
import net.ufida.x27.core.manager.RoleManager;
import net.ufida.x27.core.manager.UserManager;
import net.ufida.x27.core.model.Role;
import net.ufida.x27.core.model.User;
import net.ufida.x27.core.service.RoleService;
import net.ufida.x27.util.web.Page;
import net.ufida.x27.util.web.PageParam;

import org.apache.log4j.Logger;

public class RoleServiceImpl implements RoleService {
    private static final Logger log = Logger.getLogger(RoleServiceImpl.class);
    private RoleManager roleManager ;
    private PrivilegeManager privilegeManager ;
    private UserManager userManager ;
    
    public void deleteById(String id) {
        roleManager.deleteById(id);
    }

    public List findAllRoles() {
        return roleManager.findList();
    }

    public Role findById(String id) {
        return roleManager.findById(id);
    }
    
    public boolean isRoleNameExsits(String roleName) {
        return roleManager.isRoleNameExsits(roleName);
    }

    public List findRolesByExample(Role example) {
        return roleManager.findList(example);
    }

    public void save(Role role) {
        roleManager.save(role);
    }
    
    public void updateBasicInfo(Role param) {
        roleManager.updateBasicInfo(param);
    }

    public void authorizationRole(String roleId, String[] privilIds) {
        Role role = roleManager.findById(roleId);
        role.getPrivileges().clear();
        if (privilIds != null) {
            for (int i = 0; i < privilIds.length; i++) {
                role.addPrivilege((privilegeManager.findById(privilIds[i])));
            }
        }
        roleManager.update(role);
    }
    
    public void authorizationUser(String roleId, String[] userIds) {
        Role role = roleManager.findById(roleId) ;
        for (Iterator iter = role.getUsers().iterator(); iter.hasNext();) {
            User element = (User) iter.next();
            element.getRoles().remove(role);
        }
        role.getUsers().clear();
        if (userIds!=null) {
            for (int i = 0; i < userIds.length; i++) {
               role.addUser((userManager.findById(userIds[i])));
            }
        }
        roleManager.update(role);
    }

    public void setPrivilegeManager(PrivilegeManager privilegeManager) {
        this.privilegeManager = privilegeManager;
    }

    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void deleteByIdList(Collection list) {
        roleManager.deleteByIdList(list);
        
    }

    public List findNotBindUserListByRoleId(String roleId) {
        List bindList = this.findById(roleId).getUsers();
        List allList = userManager.findList();
        allList.removeAll(bindList);
        return allList;
    }
    
    public List findNotBindUserListByRoleId(PageParam pageParam, String roleId) {
//        List bindList = this.findById(roleId).getUsers();
        List roles = new ArrayList();
        roles.add(roleId);
        
        Page allListPage = userManager.findList(pageParam, roles);
        
        List allList = allListPage.getItems();
        return allList;
    }

    public void addRoleUser(String roleId, String[] idArray) {
        Role role = roleManager.findById(roleId);
        if (idArray!=null) {
            for (int i = 0; i < idArray.length; i++) {
               role.addUser((userManager.findById(idArray[i])));
            }
        }
        roleManager.update(role);
        
    }

    public void delRoleUser(String roleId, String[] idArray) {
        Role role = roleManager.findById(roleId);
        if (idArray!=null) {
            for (int i = 0; i < idArray.length; i++) {
               role.removeUser((userManager.findById(idArray[i])));
            }
        }
        roleManager.update(role);
        
    }
    
    public boolean findBindUserListByRoleId(String roleId) {
        List bindList = this.findById(roleId).getUsers();
        return bindList.size()>0;
    }
    
    public boolean hasUserByIdList(Collection list) {
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            if (findBindUserListByRoleId((String) iterator.next())) {
                return true;
            }
        }
        
        return false;
    }
}
