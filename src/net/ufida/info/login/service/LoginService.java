package net.ufida.info.login.service;

import java.util.List;

import net.ufida.info.login.model.SystemMenu;
import net.ufida.info.login.model.SystemRole;
import net.ufida.info.login.model.SystemUser;

/**
 * 登陆服务接口
 *
 */
public interface LoginService {
	/**
	 * 校验用户登陆权限
	 * @param username
	 * @param password
	 * @return TRUE/false
	 */
	int checkLogin(String username, String password);

	/**
	 * 获取用户对应的系统角色
	 * @param userid	用户id
	 * @param sysCode	系统代码
	 * @return
	 */
	SystemRole getSubSysRoleByUseridAndSyscode(String userid, String sysCode);

	/**
	 * 获取用户对应的系统菜单
	 * @param userid	用户id
	 * @param sysCode	系统代码
	 * @return
	 */
	List<SystemMenu> getRoleMenuByUseridAndSyscode(String userid, String sysCode);

	/**
	 * 获取角色对应的系统菜单
	 * @param roleid	角色id
	 * @return
	 */
	List<SystemMenu> getRoleMenuBySubsysroleid(String roleid);

	/**
	 * 获得序列菜单
	 * @param smList
	 * @return
	 */
	List<SystemMenu> getSortMenuTree(List<SystemMenu> smList);

	/**
	 * 从用户名获得对应用户信息
	 * @param username
	 * @return
	 */
	SystemUser getLoginUser(String username);

}
