package net.ufida.info.login.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import net.ufida.info.login.manager.LoginManager;
import net.ufida.info.login.manager.SystemMenuManager;
import net.ufida.info.login.manager.SystemRoleManager;
import net.ufida.info.login.manager.SystemRoleMenuManager;
import net.ufida.info.login.manager.SystemUserManager;
import net.ufida.info.login.model.SystemMenu;
import net.ufida.info.login.model.SystemRole;
import net.ufida.info.login.model.SystemRoleMenu;
import net.ufida.info.login.model.SystemUser;
import net.ufida.info.util.MD5;

/**
 * 登陆服务接口实现
 *
 */
public class LoginServiceImpl implements LoginService {

	private LoginManager loginManager;
	private SystemUserManager systemUserManager;
	private SystemRoleManager systemRoleManager;
	private SystemRoleMenuManager systemRoleMenuManager;
	private SystemMenuManager systemMenuManager;

	public void setSystemMenuManager(SystemMenuManager systemMenuManager) {
		this.systemMenuManager = systemMenuManager;
	}

	public void setSystemRoleManager(SystemRoleManager systemRoleManager) {
		this.systemRoleManager = systemRoleManager;
	}
	
	public void setSystemUserManager(SystemUserManager systemUserManager) {
		this.systemUserManager = systemUserManager;
	}

	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

	/**
	 * 校验用户登陆权限
	 * @param username
	 * @param password
	 * @return TRUE/false
	 */
	public int checkLogin(String username, String password) {
		int check = 0;
		SystemUser user = new SystemUser();
		user.setAccount(username);
		List rs = loginManager.findListByExample(user);
		if(rs.size()==0){
			return check;
		}else if(rs.size()>1){
			return check=1;
		}
		user = (SystemUser) rs.get(0);
		if(user.getActive().equals("0")){
			return check = 2;
		}
		check = (MD5.getMD5Str(password).equals(user.getPassword())?3:4);
		return check;
		
	}

	public List<SystemMenu> getRoleMenuBySubsysroleid(String roleid) {
		List<SystemMenu> list = loginManager.getRoleMenuBySubsysroleid(roleid);
		return list;
	}

	public List<SystemMenu> getRoleMenuByUseridAndSyscode(String userId,
			String sysCode) {
		/*List systemRoles = systemUserManager.getSystemRoles(userId);
		List userSystemRoles = new ArrayList();
		for (Iterator iterator = systemRoles.iterator(); iterator.hasNext();) {
			SystemRole systemRole = (SystemRole) iterator.next();
			if (sysCode.equalsIgnoreCase(systemRole.getSyscode()) == true) {
				userSystemRoles.add(systemRole);
			}
		}
		
		SystemRoleMenu systemRoleMenu = new SystemRoleMenu();
		systemRoleMenu.set
		List systemRoleMenus = systemRoleMenuManager.findListByExample(systemRoleMenu);
		for (Iterator iterator = systemRoleMenus.iterator(); iterator.hasNext();) {
			SystemRoleMenu systemMenu = (SystemMenu) iterator.next();
		}*/
		
		List<SystemMenu> list = loginManager.getRoleMenuByUseridAndSyscode(userId, sysCode);
		return list;
	}

	public void getRoleSubMenuBySubsysmenuid(String roleid) {
		// TODO Auto-generated method stub
		
	}

	public SystemRole getSubSysRoleByUseridAndSyscode(String userid,
			String sysCode) {
		SystemRole role = loginManager.getSubSysRoleByUseridAndSyscode(userid, sysCode);
		return role;
	}

	public List<SystemMenu> getSortMenuTree(List<SystemMenu> smList) {
		List<SystemMenu> list = new ArrayList<SystemMenu>();
    	TreeMap<String,SystemMenu> pMap = new TreeMap<String,SystemMenu>();
    	
		for (int i = 0; smList!=null && i < smList.size(); i++) {
			SystemMenu sysMenu = smList.get(i);
			if(sysMenu.getLevel()==1)
				pMap.put(String.valueOf(sysMenu.getSort_value()),sysMenu);
		}

		Collection<SystemMenu> col = pMap.values();
		Iterator<SystemMenu> it = col.iterator();
		while (it.hasNext()) {
			SystemMenu p = it.next();
			TreeMap<String,SystemMenu> bMap = new TreeMap<String,SystemMenu>();
			for (int i = 0; smList!=null && i < smList.size(); i++) {
				SystemMenu sysMenu = smList.get(i);
				if(sysMenu.getLevel()!=1 && p.getIdStr()==sysMenu.getPid()){
					for (int j = 0;; j++) {
						if(bMap.keySet().contains(String.valueOf(sysMenu.getSort_value()*100+j))){
							
						}else{
							bMap.put(String.valueOf(sysMenu.getSort_value()*100+j),sysMenu);
							break;
						}
					}
				}
			}
			SystemMenu sm = new SystemMenu();
			sm.setIdStr(p.getIdStr());
			sm.setPid(p.getPid());
			sm.setLink(p.getLink());
			sm.setName(p.getName());
			sm.setItems(bMap.values());
			Iterator<SystemMenu> iterator = bMap.values().iterator();
			list.add(sm);
		}
		return list;
	}

	public SystemUser getLoginUser(String username) {
		SystemUser user = new SystemUser();
		user.setAccount(username);
		List rs = loginManager.findListByExample(user);
		return (SystemUser)rs.get(0);
	}

	
}
