package net.ufida.info.login.model;

import java.io.Serializable;

import net.ufida.x27.util.web.JSONNotAware;

/**
 * 系统类
 * @hibernate.class table="tb_subsys" dynamic-insert="true" dynamic-update="true" lazy="false"
 */
public class System implements JSONNotAware, Serializable, Cloneable {
	/**
     * 主键ID
     * @hibernate.id column="sys_id" generator-class="native" type="integer" length="32"
     */
	private int idStr;
	
	/**
     * 系统中文名
     * @hibernate.property column="sys_name" type="string"
     */
	private String name;
	
	/**
     * 系统代码
     * @hibernate.property column="sys_code" type="string"
     */
	private String code;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
