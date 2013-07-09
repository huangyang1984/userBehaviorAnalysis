package net.ufida.info.login.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.ufida.x27.util.web.JSONNotAware;

/**
 * 系统菜单类
 * @hibernate.class table="tb_subsys_menu" dynamic-insert="true" dynamic-update="true" lazy="false"
 */
public class SystemMenu implements JSONNotAware, Serializable, Cloneable {
	/**
     * 主键ID
     * @hibernate.id column="subsys_menu_id" generator-class="native" type="integer" length="32"
     */
	private int idStr;
	
	/**
     * 菜单中文名
     * @hibernate.property column="menu_name" type="string"
     */
	private String name;
	
	/**
     * 菜单链接
     * @hibernate.property column="link" type="string"
     */
	private String link;
	
	/**
     * 菜单排序值
     * @hibernate.property column="sort_value" type="integer"
     */
	private int sort_value;
	
	/**
     * 菜单层次
     * @hibernate.property column="level" type="integer"
     */
	private int level;
	
	/**
     * 菜单父id
     * @hibernate.property column="parent_id" type="integer"
     */
	private int pid;
	
	/**
     * 系统代码
     * @hibernate.property column="sys_code" type="string"
     */
	private String syscode;
	
	/**
	 * 子菜单
	 */
	private Collection<SystemMenu> items;
	
	/**
	 * 关联系统角色列表——暂时还是不用吧。。该死的Hibernate。该死的多角色
	 * 
	 * @hibernate.bag cascade="save-update" table="tb_subsys_role_menu" 
	 *                inverse="true" lazy="true"
	 * @hibernate.key column="subsys_menu_id"
	 * @hibernate.many-to-many class="net.gbicc.info.login.model.SystemRole"
	 *                         column="subsys_role_id"
	 */
//	private List sysRoleList = new ArrayList(0);
	
	/**
	 * 关联系统角色菜单关联列表
	 * @hibernate.bag cascade="save-update" inverse="false"  order-by="level,sort_value" lazy="true"
     * @hibernate.key column="subsys_menu_id" 
     * @hibernate.one-to-many class="net.gbicc.info.login.model.SystemRoleMenu" 
     */
	private List sysRoleMenuList = new ArrayList(0);

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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getSort_value() {
		return sort_value;
	}

	public void setSort_value(int sortValue) {
		sort_value = sortValue;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getSyscode() {
		return syscode;
	}

	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}
	
	public Collection<SystemMenu> getItems() {
		return items;
	}
	public void setItems(Collection<SystemMenu> items) {
		this.items = items;
	}

	public List getSysRoleMenuList() {
		return sysRoleMenuList;
	}

	public void setSysRoleMenuList(List sysRoleMenuList) {
		this.sysRoleMenuList = sysRoleMenuList;
	}

//	public List getSysRoleList() {
//		return sysRoleList;
//	}
//
//	public void setSysRoleList(List sysRoleList) {
//		this.sysRoleList = sysRoleList;
//	}
	
}
