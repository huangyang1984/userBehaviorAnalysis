package net.ufida.info.login.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.ufida.x27.util.web.JSONNotAware;

/**
 * 系统用户类
 * @hibernate.class table="tb_sys_user" dynamic-insert="true" dynamic-update="true" lazy="false"
 */
public class SystemUser implements JSONNotAware, Serializable, Cloneable {
	/**
     * 主键ID
     * @hibernate.id column="SYS_USER_ID" generator-class="native" type="integer" length="32"
     */
	private int idStr;
	
	/**
     * 用户账号
     * @hibernate.property column="USER_NAME" type="string"
     */
	private String account;
	
	/**
     * 用户中文名
     * @hibernate.property column="REAL_NAME" type="string"
     */
	private String name;
	
	/**
     * 用户密码
     * @hibernate.property column="PASSWORD" type="string"
     */
	private String password;
	
	/**
     * 用户启用状态
     * @hibernate.property column="STATUS" type="string"
     */
	private String active;
	
	/**
     * 用户在线状态
     * @hibernate.property column="ON_LINE" type="string"
     */
	private String online;
	
	/**
     * 用户最后一次登录IP
     * @hibernate.property column="LAST_LOGIN_IP" type="string"
     */
	private String last_ip;

	/**
     * 用户最后一次登录时间
     * @hibernate.property column="LAST_LOGIN_DATE" type="timestamp"
     */
	private Date last_date;
	
	/**
	 * 关联系统角色列表
	 * 
	 * @hibernate.bag cascade="save-update" table="tb_subsys_user_role" 
	 *                inverse="true" lazy="true"
	 * @hibernate.key column="sys_user_id"
	 * @hibernate.many-to-many class="net.gbicc.info.login.model.SystemRole"
	 *                         column="subsys_role_id"
	 */
	private List sysRoleList = new ArrayList(0);

	//以下是getter和setter方法
	
	public int getIdStr() {
		return idStr;
	}

	public void setIdStr(int idStr) {
		this.idStr = idStr;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public String getLast_ip() {
		return last_ip;
	}

	public void setLast_ip(String lastIp) {
		last_ip = lastIp;
	}

	public Date getLast_date() {
		return last_date;
	}

	public void setLast_date(Date lastDate) {
		last_date = lastDate;
	}

	public List getSysRoleList() {
		return sysRoleList;
	}

	public void setSysRoleList(List sysRoleList) {
		this.sysRoleList = sysRoleList;
	}

}
