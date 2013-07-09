/**
 * 
 */
package net.ufida.info.mahout.model;

import java.io.Serializable;

import net.ufida.x27.util.web.JSONNotAware;

/**
 * 原始数据模型model
 * @author steven.yang	
 * @hibernate.class table="tmp_good_order" dynamic-insert="true" dynamic-update="true" lazy="false"
 */
public class BasicRemmenderModel implements JSONNotAware, Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 主键ID
     * @hibernate.id column="id" generator-class="native" type="integer" length="32"
     */
	private int idStr;

	/**
     * 用户ID
     * @hibernate.property column="user_id" type="integer"
     */
	private int userId;
	
	/**
	 * 商品ID
	 * @hibernate.property column="goods_id" type="integer"
	 */
	private int productId;
	
	/**
	 * 订单ID
	 * @hibernate.property column="order_id" type="integer"
	 */
	private int orderId;
	
	/**
	 * 核算指标
	 * @hibernate.property column="goods_number" type="integer"
	 */
	private int indicator;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getIndicator() {
		return indicator;
	}

	public void setIndicator(int indicator) {
		this.indicator = indicator;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getIdStr() {
		return idStr;
	}

	public void setIdStr(int idStr) {
		this.idStr = idStr;
	}
	
}
