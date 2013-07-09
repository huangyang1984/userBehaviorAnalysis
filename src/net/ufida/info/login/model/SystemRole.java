package net.ufida.info.login.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.ufida.x27.util.web.JSONNotAware;

/**
 * 系统角色类
 * @hibernate.class table="tb_subsys_role" dynamic-insert="true" dynamic-update="true" lazy="false"
 */
public class SystemRole implements JSONNotAware, Serializable, Cloneable {
	/**
     * 主键ID
     * @hibernate.id column="subsys_role_id" generator-class="native" type="integer" length="32"
     */
	private int idStr;
	
	/**
     * 角色中文名
     * @hibernate.property column="role_name" type="string"
     */
	private String name;
	
	/**
     * 系统代码
     * @hibernate.property column="sys_code" type="string"
     */
	private String syscode;

	/**
	 * 关联系统菜单列表——暂时还是不用吧。。该死的Hibernate。该死的多角色
	 * 
	 * @hibernate.bag cascade="save-update" table="tb_subsys_role_menu" 
	 *                inverse="true" lazy="true"
	 * @hibernate.key column="subsys_role_id"
	 * @hibernate.many-to-many class="net.gbicc.info.login.model.SystemMenu"
	 *                         column="subsys_menu_id"
	 */
//	private List sysMenuList = new ArrayList(0);
	
	/**
	 * 关联系统角色菜单关联列表
	 * @hibernate.bag cascade="save-update" inverse="false"  order-by="level,sort_value" lazy="true"
     * @hibernate.key column="subsys_role_id" 
     * @hibernate.one-to-many class="net.gbicc.info.login.model.SystemRoleMenu" 
     */
	private List sysRoleMenuList = new ArrayList(0);
	
	/**
	 * 关联系统用户列表
	 * 
	 * @hibernate.bag cascade="save-update" table="tb_subsys_user_role" 
	 *                inverse="true" lazy="true"
	 * @hibernate.key column="subsys_role_id"
	 * @hibernate.many-to-many class="net.gbicc.info.login.model.SystemUser"
	 *                         column="sys_user_id"
	 */
	private List userList = new ArrayList(0);
	
	//以下是getter和setter方法
	public int getIdStr() {
		return idStr;
	}

	public void setIdStr(int idStr) {
		this.idStr = idStr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSyscode() {
		return syscode;
	}

	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}

//	public List getSysMenuList() {
//		return sysMenuList;
//	}
//
//	public void setSysMenuList(List sysMenuList) {
//		this.sysMenuList = sysMenuList;
//	}

	public List getUserList() {
		return userList;
	}

	public void setUserList(List userList) {
		this.userList = userList;
	}

	public List getSysRoleMenuList() {
		return sysRoleMenuList;
	}

	public void setSysRoleMenuList(List sysRoleMenuList) {
		this.sysRoleMenuList = sysRoleMenuList;
	}

}
