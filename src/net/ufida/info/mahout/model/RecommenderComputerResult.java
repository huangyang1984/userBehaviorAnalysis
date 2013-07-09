/**
 * 
 */
package net.ufida.info.mahout.model;

import java.io.Serializable;

/**
 * 推荐结果模型
 * @author Steven.yang
 *
 */
public class RecommenderComputerResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 推荐优先级指数
	 */
	private float priority;
	
	/**
	 * 商品Id
	 */
	private long productId;
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品类别Id
	 */
	private int catId;
	
	/**
	 * 商品类别名称
	 */
	private String catName;

	public float getPriority() {
		return priority;
	}

	public void setPriority(float priority) {
		this.priority = priority;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return the catName
	 */
	public String getCatName() {
		return catName;
	}

	/**
	 * @param catName the catName to set
	 */
	public void setCatName(String catName) {
		this.catName = catName;
	}

	/**
	 * @return the catId
	 */
	public int getCatId() {
		return catId;
	}

	/**
	 * @param catId the catId to set
	 */
	public void setCatId(int catId) {
		this.catId = catId;
	}


}
