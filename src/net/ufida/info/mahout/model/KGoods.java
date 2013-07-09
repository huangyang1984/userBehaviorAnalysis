/**
 * 
 */
package net.ufida.info.mahout.model;

import java.io.Serializable;
import java.math.BigDecimal;

import net.ufida.x27.util.web.JSONNotAware;

/**
 * @author Steven.yang
 *
 */
public class KGoods implements JSONNotAware, Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int goodsId;
	
	private int catId;
	
	private String goodsSn;
	
	private String goodsName;
	
	private String goodsNameStyle;

	/**
	 * @return the goodsId
	 */
	public int getGoodsId() {
		return goodsId;
	}

	/**
	 * @param goodsId the goodsId to set
	 */
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
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

	/**
	 * @return the goodsSn
	 */
	public String getGoodsSn() {
		return goodsSn;
	}

	/**
	 * @param goodsSn the goodsSn to set
	 */
	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
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
	 * @return the goodsNameStyle
	 */
	public String getGoodsNameStyle() {
		return goodsNameStyle;
	}

	/**
	 * @param goodsNameStyle the goodsNameStyle to set
	 */
	public void setGoodsNameStyle(String goodsNameStyle) {
		this.goodsNameStyle = goodsNameStyle;
	}
	
/*	private int clickCount;
	
	private int brandId;
	
	private String providerName;
	
	private int goodsNumber;
	
	private BigDecimal goodsWeight;
	
	private BigDecimal markerPrice;
	
	private BigDecimal shopPrice;
	
	private BigDecimal promotePrice;
	
	private int promoteStartDate;
	
	private int promoteEndDate;
	
	private int warnNumber;
	
	private String keywords;
	*/
	
	
	
}
