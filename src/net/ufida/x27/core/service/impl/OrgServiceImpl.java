package net.ufida.x27.core.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import net.ufida.x27.core.manager.OrgManager;
import net.ufida.x27.core.manager.RoleManager;
import net.ufida.x27.core.manager.UserManager;
import net.ufida.x27.core.model.Organization;
import net.ufida.x27.core.model.Role;
import net.ufida.x27.core.model.User;
import net.ufida.x27.core.service.OrgService;
import net.ufida.x27.core.util.PasswordUtils;
import net.ufida.x27.dict.model.Dictionary;
import net.ufida.x27.exception.X27Exception;
import net.ufida.x27.util.hibernate.ModelUtils;
import net.ufida.x27.util.web.Page;
import net.ufida.x27.util.web.PageParam;

import org.acegisecurity.providers.encoding.Md5PasswordEncoder;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class OrgServiceImpl implements OrgService {
    
    private static final Logger log = Logger.getLogger(OrgServiceImpl.class);
    
    private OrgManager orgManager;
    private RoleManager roleManager;
    private UserManager userManager;
    
    public void updateUserStatus(String userId, String userStatus) {
        userManager.updateUserStatus(userId, userStatus);
    }

    /**构造2级联动所需数据*/
    public Collection findList2LevelEmployeeAndDepart() {
        List orgList = orgManager.findList("orgName");
        LinkedHashMap orgMap = new LinkedHashMap(orgList.size());
        for (Iterator iterator = orgList.iterator(); iterator.hasNext();) {
            Organization org = (Organization) iterator.next();
            Dictionary dictionary = new Dictionary();
            dictionary.setCode(org.getIdStr());
            dictionary.setName(org.getOrgName());
            orgMap.put(dictionary.getCode(), dictionary);
        }
        for (Iterator iterator = userManager.findList("userName").iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();
            List orgListTemp = user.getOrganizations();
            //用户必须属于某个部门，不属于任何部门不显示
            if (orgListTemp.size() == 0) {
                continue;
            }
            String orgId = ((Organization) orgListTemp.get(0)).getIdStr();
            Dictionary dictionary = (Dictionary) orgMap.get(orgId);
            Assert.notNull(dictionary, "invalid project type:" + orgId);
            dictionary.addEnum(user.getIdStr(), user.getUserName());
        }
        return orgMap.values();
    }
    
    public void saveOrg(Organization entity) {
        orgManager.save(entity);
    }

    /** only update properties not null */
    public void updateOrgByParam(Organization param) {
        orgManager.updateByParam(param);
    }

    public List findAllOrgs() {
        return orgManager.findList();
    }

    public List findOrgsByExample(Organization example) {
        return orgManager.findList(example);
    }

    public Organization findOrgById(String id) {
        return orgManager.findById(id);
    }

    public Organization findOrgByOrgName(String orgName) {
        return orgManager.findByOrgName(orgName);
    }

    public void deleteOrgById(String id) {
        orgManager.deleteById(id);
    }

    public void saveUser(User entity) {
        userManager.save(entity);
    }

    /** only update properties not null */
    public void updateUserByParam(User param) {
        userManager.updateByParam(param);
    }
    
    public List findAllUsers() {
        return userManager.findList();
    }

    public List findUsersByExample(User example) {
        return userManager.findList(example);
    }
    
    public Page findUsersPagesByExample(PageParam pageParam, User example) {
        return userManager.findList(pageParam, example);
    }

    public User findUserById(String id) {
        return userManager.findById(id);
    }
    
    public User findUserByUserName(String userName) {
        return (User) userManager.findByUserName(userName);
    }
    
    public User findByUniqueUserName(String userName) {
        return (User) userManager.findByUniqueUserName(userName);
    }

    public User findUserByEmail(String email) {
        return (User) userManager.findByEmail(email);
    }

    public void addChildOrg(String orgId, Organization child) {
        orgManager.addChild(orgId, child);
    }

    public List findOrgMembers(String orgId) {
        return orgManager.findById(orgId).getUsers();
    }
    
    public List findOrgMembersByOrgCode(String orgCode) {
        Organization organization = orgManager.findByOrgCode(orgCode);
        if (organization == null) {
            return new ArrayList(0);
        }
        
        return organization.getUsers();
    }

    public void removeOrgMember(String orgId, String userId) {
        Organization org = orgManager.findById(orgId);
        User user = userManager.findById(userId);        
        org.removeMember(user);
        orgManager.update(org);
    }

    public void registUser(User user, String[]roles, String[] orgs) {     
        User userExsit = userManager.findByUniqueUserName(user.getUserName());
        if (userExsit != null) {
            throw new X27Exception("已存在相同的用户名!");
        }
        
        user.setPassword(PasswordUtils.hash(user.getPassword()));
        if (roles != null) {
            for (int i = 0; i < roles.length; i++) {
                user.addRole((roleManager.findById(roles[i])));
            }
        }
        if (orgs!=null) {
            for (int i = 0; i < orgs.length; i++) {
                user.addOrg((this.findOrgById(orgs[i])));
            }
        }
        userManager.save(user);
//        log.debug(user);
    }

//    public void updateUserByParam(User param) {
//        User user = this.findUserById(param.getIdStr());
//        param.setOrganizations(null);
//        param.setRoles(null);
//        ModelUtils.transferValue(param, user);
//        
//        userManager.update(user);
//    }
    
    public void updateUserRoleOrgByParam(User param, String[] roleIds, String[] orgIds) {
        User user = this.findUserById(param.getIdStr());
        param.setOrganizations(null);
        param.setRoles(null);
        ModelUtils.transferValue(param, user);
        //建立用户与角色 关联
        for (Iterator iter = user.getRoles().iterator(); iter.hasNext();) {
            Role element = (Role) iter.next();
            element.getUsers().remove(user);
        }
        user.getRoles().clear();
        if (roleIds != null) {
            for (int i = 0; i < roleIds.length; i++) {
                user.addRole((roleManager.findById(roleIds[i])));
            }
        }
        //建立用户与组织关联
        for (Iterator iter = user.getOrganizations().iterator(); iter.hasNext();) {
            Organization element = (Organization) iter.next();
            element.getUsers().remove(user);
        }
        user.getOrganizations().clear();
        if (orgIds != null) {
            for (int i = 0; i < orgIds.length; i++) {
               user.addOrg((orgManager.findById(orgIds[i])));
            }
        }
        userManager.update(user);
    }
    
    public List findTopLevelOrgs() {
        return orgManager.findTopLevelOrgs();
    }
    
    public void addOrgMember(String orgId, String userId) {
        Organization org = orgManager.findById(orgId);
        User user = userManager.findById(userId);        
        org.addMember(user);
        orgManager.update(org);
    }
    
    public void saveOrg(String parentOrgName, Organization org) {
        org.setParentOrganization(this.findOrgByName(parentOrgName));
        orgManager.save(org);
    }

    public Organization findOrgByName(String name) {
        return orgManager.findByOrgName(name);
    }

    public void updateOrgByParam(String parentOrgName, Organization param) {
        orgManager.updateOrgByParam(parentOrgName, param);
    }

    public void addOrgMembers(String orgId, String[] userIds) {
        Organization org = this.findOrgById(orgId);
        //建立用户与角色 关联
        for (Iterator iter = org.getUsers().iterator(); iter.hasNext();) {
            User element = (User) iter.next();
            element.getOrganizations().remove(org);
        }
        org.getUsers().clear();
        if (userIds != null) {
            for (int i = 0; i < userIds.length; i++) {
               org.addMember((userManager.findById(userIds[i])));
            }
        }
        orgManager.update(org);
        
    }

    public void setOrgManager(OrgManager orgManager) {
        this.orgManager = orgManager;
    }

    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public void resetPwd(String userId, String pwd) {
        User param = new User();
        param.setOrganizations(null);
        param.setRoles(null);
        param.setIdStr(userId);
        param.setPassword(PasswordUtils.hash(pwd));
        this.updateUserByParam(param);
    }
    
    public boolean resetUserPwd(String userId, String oldPwd, String newPwd) {
        User param = userManager.findById(userId);
        
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        String oldPwdEncode = md5.encodePassword(oldPwd, null);
        if (oldPwdEncode.equals(param.getPassword())) {// 登陆密码相同
            resetPwd(userId, newPwd);
            
            return true;
        }
        
        return false;
    }

    public String findStr2LevelEmployeeAndDepart() {
        StringBuffer sb = new StringBuffer();

        // 将所有部门代码读入内存
        List orgList = orgManager.findList();
        int orgs = orgList.size();
        if (orgs == 0) {
            return "";
        }

        sb.append("[");
        int i = 0;
        for (Iterator iterator = orgList.iterator(); iterator.hasNext(); ++i) {
            Organization org = (Organization) iterator.next();
            sb.append("{\"id\": \"" + org.getIdStr() + "," + org.getOrgCode() + "\",\"text\": \""
                    + org.getOrgShortName() + "\"");

            List userList = org.getUsers();

            int users = userList.size();
            if (users > 0) {
                sb.append(",\"children\": [");
            }

            int j = 0;
            for (Iterator iterator2 = userList.iterator(); iterator2.hasNext(); ++j) {
                User user = (User) iterator2.next();
                sb.append("{ \"id\": \"" + user.getIdStr() + "," + user.getUserName() + "\",\"text\":\""
                        + user.getRealName() + "\",\"leaf\": true,\"checked\":false,\"href\":\"\"}");

                if (j < users - 1) {
                    sb.append(",");
                } else if (j == users - 1) {
                    sb.append("]");
                }
            }

            sb.append("}");
            if (i < orgs - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
    
    /**
     * 获取部门无限制层次数
     * @return
     */
    public String findDepartTree() {
        StringBuffer sb = new StringBuffer();

        // 将所有部门代码读入内存
        List orgList = orgManager.findList();
        int orgs = orgList.size();
        if (orgs == 0) {
            return "";
        }

        sb.append("[");
        sb.append(generateDeptJsonTree(orgList));
        sb.append("]");
        
        return sb.toString();
    }
    
    private String generateDeptJsonTree(List orgList) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int orgSize = orgList.size();
        for (Iterator iterator = orgList.iterator(); iterator.hasNext(); i++) {
            Organization org = (Organization) iterator.next();
            
            List childOrgs = org.getChildOrgs();
            int size = childOrgs.size();
            
            if (size > 1) {// 非叶子结点
                sb.append("{\"id\": \"" + org.getIdStr() + "\",\"text\": \""
                        + org.getOrgShortName() + "," + StringUtils.trimToEmpty(org.getOrgType()) + "\",\"children\": [");
                
                sb.append(generateDeptJsonTree(childOrgs));
                sb.append("]}");
                
                
            } else {// 叶子结点
                sb.append("{\"id\": \"" + org.getIdStr() + "\",\"leaf\": true,\"checked\":false,\"text\": \""
                        + org.getOrgShortName() + "\"}");
            }
            
            if (i <= orgSize - 2 && orgSize >= 2) {
                sb.append(",");
            }
        }
        
        return sb.toString();
    }
    
    public void deleteOrgs(String orgIds) {
        this.orgManager.deleteByIdList(Arrays.asList(orgIds.split(",")));
    }
    
    public void updateUserByParam(User param, String[] roleIds, String[] orgIds) {
        User user = this.findUserById(param.getIdStr());
        param.setOrganizations(null);
        param.setRoles(null);
        ModelUtils.transferValue(param, user);
        
        if (roleIds != null) {
            //建立用户与角色 关联
            for (Iterator iter = user.getRoles().iterator(); iter.hasNext();) {
                Role element = (Role) iter.next();
                element.getUsers().remove(user);
                
            }
            user.getRoles().clear();
            
            for (int i = 0; i < roleIds.length; i++) {
                user.addRole((roleManager.findById(roleIds[i])));
            }
        }
        
        if (orgIds != null) {
            //建立用户与组织关联
            for (Iterator iter = user.getOrganizations().iterator(); iter.hasNext();) {
                Organization element = (Organization) iter.next();
                element.getUsers().remove(user);
            }
            user.getOrganizations().clear();
            
            for (int i = 0; i < orgIds.length; i++) {
                user.addOrg((orgManager.findById(orgIds[i])));
            }
        }
        
        userManager.update(user);
    }
    
    public String findOrgByUserName(String userName) {
        return userManager.findOrgByUserName(userName);
    }
    
    public List findOrgTopList(String orgCode) {
        return orgManager.findOrgTopList(orgCode);
    }
}