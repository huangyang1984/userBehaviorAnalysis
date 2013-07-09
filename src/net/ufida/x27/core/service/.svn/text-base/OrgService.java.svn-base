package net.ufida.x27.core.service;

import java.util.Collection;
import java.util.List;

import net.ufida.x27.core.model.Organization;
import net.ufida.x27.core.model.User;
import net.ufida.x27.util.web.Page;
import net.ufida.x27.util.web.PageParam;

public interface OrgService {
    
    void updateUserStatus(String userId, String userStatus);
    
    /**构造2级联动所需数据*/
    Collection findList2LevelEmployeeAndDepart();
    
    void saveOrg(Organization entity);

    /** only update properties not null */
    void updateOrgByParam(Organization param);

    List findAllOrgs();

    List findOrgsByExample(Organization example);

    Organization findOrgById(String id);

    Organization findOrgByOrgName(String orgName);

    void deleteOrgById(String id);

    void saveUser(User entity);

    /** only update properties not null */
    void updateUserByParam(User param);

//    public List findAllNotCitedByBrokerUsers();
    
    List findAllUsers();

    List findUsersByExample(User example);
    
    Page findUsersPagesByExample(PageParam pageParam, User example);

    User findUserById(String id);

    User findUserByUserName(String userName);
    
    User findByUniqueUserName(String userName);

    User findUserByEmail(String email);
    
    List findOrgMembers(String orgId);
    
    void addOrgMember(String orgId,String userId);
    
    void saveOrg(String parentOrgName,Organization org);
    
    void addChildOrg(String orgId,Organization child);
    
    void removeOrgMember(String orgId,String userId);
    
    void registUser(User user,String[]roles,String[] orgs);

    void updateUserRoleOrgByParam(User param, String[] roleIds, String[] orgIds);
    
    List findTopLevelOrgs () ;
    
    Organization findOrgByName(String name);

    void updateOrgByParam(String parentOrgName, Organization param);

    void addOrgMembers(String orgId, String[] userIds);
    
    void resetPwd(String userId, String pwd);
    
    boolean resetUserPwd(String userId, String oldPwd, String newPwd);
    
    String findStr2LevelEmployeeAndDepart();
    
    String findDepartTree();
    
    void deleteOrgs(String orgIds);
    
    void updateUserByParam(User param, String[] roleIds, String[] orgIds);
    
    /**
     * 根据用户名查询所属机构码
     * @param userName
     * @return
     */
    public String findOrgByUserName(String userName);
    
    public List findOrgTopList(String orgCode);
    
    public List findOrgMembersByOrgCode(String orgCode);
}