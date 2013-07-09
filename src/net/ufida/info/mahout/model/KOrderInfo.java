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
public class KOrderInfo implements JSONNotAware, Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int orderId;
	
	private String orderSn;
	
	private int userId;
	
	private int orderStatus;
	
	private int shippingStatus;
	
	private int payStatus;
	
	private String consignee;
	
	private int country;
	
	private int province;
	
	private int city;
	
	private int district;
	
	private String address;
	
	private String zipCode;
	
	private String tel;
	
	private String mobile;
	
	private String email;
	
	private String bestTime;
	
	private String signBuilding;
	
	private String postScript;
	
	private int shippingId;
	
	private String shippingName;
	
	private int payId;
	
	private String payName;
	
	private String howOos;
	
	private String howSurplus;
	
	private String parkName;
	
	private String cardName;
	
	private String cardMessage;
	
	private String invPayee;
	
	private String invContent;
	
	private BigDecimal goodsAmount;
	
	private BigDecimal shippingFee;
	
	private BigDecimal insureFee;
	
	private BigDecimal payFee;
	
	private BigDecimal packFee;
	
	private BigDecimal cardFee;
	
	private BigDecimal moneyPaid;
	
	private BigDecimal surplus;
	
	private int integral;
	
	private BigDecimal integralMoney;
	
	private BigDecimal bonus;
	
	private BigDecimal orderAmount;
	
	private int fromAd;
	
	private String referer;
	
	private int addTime;
	
	private int confirmTime;
	
	private int payTime;
	
	private int shippingTime;
	
	private int packId;
	
	private int cardId;
	
    private int bonusId;
    
    private String invoiceNo;
    
    private String extensionCode;
    
    private int extensionId;
    
    private String toBuyer;
    
    private String payNote;
    
    private int agencyId;
    
    private String invType;
    
    private BigDecimal tax;
    
    private int isSeparate;
    
    private int parentId;
    
    private BigDecimal discount;

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the orderSn
	 */
	public String getOrderSn() {
		return orderSn;
	}

	/**
	 * @param orderSn the orderSn to set
	 */
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the orderStatus
	 */
	public int getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @return the shippingStatus
	 */
	public int getShippingStatus() {
		return shippingStatus;
	}

	/**
	 * @param shippingStatus the shippingStatus to set
	 */
	public void setShippingStatus(int shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	/**
	 * @return the payStatus
	 */
	public int getPayStatus() {
		return payStatus;
	}

	/**
	 * @param payStatus the payStatus to set
	 */
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * @return the consignee
	 */
	public String getConsignee() {
		return consignee;
	}

	/**
	 * @param consignee the consignee to set
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	/**
	 * @return the country
	 */
	public int getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(int country) {
		this.country = country;
	}

	/**
	 * @return the province
	 */
	public int getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(int province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public int getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(int city) {
		this.city = city;
	}

	/**
	 * @return the district
	 */
	public int getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(int district) {
		this.district = district;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the bestTime
	 */
	public String getBestTime() {
		return bestTime;
	}

	/**
	 * @param bestTime the bestTime to set
	 */
	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	/**
	 * @return the signBuilding
	 */
	public String getSignBuilding() {
		return signBuilding;
	}

	/**
	 * @param signBuilding the signBuilding to set
	 */
	public void setSignBuilding(String signBuilding) {
		this.signBuilding = signBuilding;
	}

	/**
	 * @return the postScript
	 */
	public String getPostScript() {
		return postScript;
	}

	/**
	 * @param postScript the postScript to set
	 */
	public void setPostScript(String postScript) {
		this.postScript = postScript;
	}

	/**
	 * @return the shippingId
	 */
	public int getShippingId() {
		return shippingId;
	}

	/**
	 * @param shippingId the shippingId to set
	 */
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	/**
	 * @return the shippingName
	 */
	public String getShippingName() {
		return shippingName;
	}

	/**
	 * @param shippingName the shippingName to set
	 */
	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	/**
	 * @return the payId
	 */
	public int getPayId() {
		return payId;
	}

	/**
	 * @param payId the payId to set
	 */
	public void setPayId(int payId) {
		this.payId = payId;
	}

	/**
	 * @return the payName
	 */
	public String getPayName() {
		return payName;
	}

	/**
	 * @param payName the payName to set
	 */
	public void setPayName(String payName) {
		this.payName = payName;
	}

	/**
	 * @return the howOos
	 */
	public String getHowOos() {
		return howOos;
	}

	/**
	 * @param howOos the howOos to set
	 */
	public void setHowOos(String howOos) {
		this.howOos = howOos;
	}

	/**
	 * @return the howSurplus
	 */
	public String getHowSurplus() {
		return howSurplus;
	}

	/**
	 * @param howSurplus the howSurplus to set
	 */
	public void setHowSurplus(String howSurplus) {
		this.howSurplus = howSurplus;
	}

	/**
	 * @return the parkName
	 */
	public String getParkName() {
		return parkName;
	}

	/**
	 * @param parkName the parkName to set
	 */
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	/**
	 * @return the cardName
	 */
	public String getCardName() {
		return cardName;
	}

	/**
	 * @param cardName the cardName to set
	 */
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	/**
	 * @return the cardMessage
	 */
	public String getCardMessage() {
		return cardMessage;
	}

	/**
	 * @param cardMessage the cardMessage to set
	 */
	public void setCardMessage(String cardMessage) {
		this.cardMessage = cardMessage;
	}

	/**
	 * @return the invPayee
	 */
	public String getInvPayee() {
		return invPayee;
	}

	/**
	 * @param invPayee the invPayee to set
	 */
	public void setInvPayee(String invPayee) {
		this.invPayee = invPayee;
	}

	/**
	 * @return the invContent
	 */
	public String getInvContent() {
		return invContent;
	}

	/**
	 * @param invContent the invContent to set
	 */
	public void setInvContent(String invContent) {
		this.invContent = invContent;
	}

	/**
	 * @return the goodsAmount
	 */
	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}

	/**
	 * @param goodsAmount the goodsAmount to set
	 */
	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	/**
	 * @return the shippingFee
	 */
	public BigDecimal getShippingFee() {
		return shippingFee;
	}

	/**
	 * @param shippingFee the shippingFee to set
	 */
	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}

	/**
	 * @return the insureFee
	 */
	public BigDecimal getInsureFee() {
		return insureFee;
	}

	/**
	 * @param insureFee the insureFee to set
	 */
	public void setInsureFee(BigDecimal insureFee) {
		this.insureFee = insureFee;
	}

	/**
	 * @return the payFee
	 */
	public BigDecimal getPayFee() {
		return payFee;
	}

	/**
	 * @param payFee the payFee to set
	 */
	public void setPayFee(BigDecimal payFee) {
		this.payFee = payFee;
	}

	/**
	 * @return the packFee
	 */
	public BigDecimal getPackFee() {
		return packFee;
	}

	/**
	 * @param packFee the packFee to set
	 */
	public void setPackFee(BigDecimal packFee) {
		this.packFee = packFee;
	}

	/**
	 * @return the cardFee
	 */
	public BigDecimal getCardFee() {
		return cardFee;
	}

	/**
	 * @param cardFee the cardFee to set
	 */
	public void setCardFee(BigDecimal cardFee) {
		this.cardFee = cardFee;
	}

	/**
	 * @return the moneyPaid
	 */
	public BigDecimal getMoneyPaid() {
		return moneyPaid;
	}

	/**
	 * @param moneyPaid the moneyPaid to set
	 */
	public void setMoneyPaid(BigDecimal moneyPaid) {
		this.moneyPaid = moneyPaid;
	}

	/**
	 * @return the surplus
	 */
	public BigDecimal getSurplus() {
		return surplus;
	}

	/**
	 * @param surplus the surplus to set
	 */
	public void setSurplus(BigDecimal surplus) {
		this.surplus = surplus;
	}

	/**
	 * @return the integral
	 */
	public int getIntegral() {
		return integral;
	}

	/**
	 * @param integral the integral to set
	 */
	public void setIntegral(int integral) {
		this.integral = integral;
	}

	/**
	 * @return the integralMoney
	 */
	public BigDecimal getIntegralMoney() {
		return integralMoney;
	}

	/**
	 * @param integralMoney the integralMoney to set
	 */
	public void setIntegralMoney(BigDecimal integralMoney) {
		this.integralMoney = integralMoney;
	}

	/**
	 * @return the bonus
	 */
	public BigDecimal getBonus() {
		return bonus;
	}

	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

	/**
	 * @return the orderAmount
	 */
	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	/**
	 * @return the fromAd
	 */
	public int getFromAd() {
		return fromAd;
	}

	/**
	 * @param fromAd the fromAd to set
	 */
	public void setFromAd(int fromAd) {
		this.fromAd = fromAd;
	}

	/**
	 * @return the referer
	 */
	public String getReferer() {
		return referer;
	}

	/**
	 * @param referer the referer to set
	 */
	public void setReferer(String referer) {
		this.referer = referer;
	}

	/**
	 * @return the addTime
	 */
	public int getAddTime() {
		return addTime;
	}

	/**
	 * @param addTime the addTime to set
	 */
	public void setAddTime(int addTime) {
		this.addTime = addTime;
	}

	/**
	 * @return the confirmTime
	 */
	public int getConfirmTime() {
		return confirmTime;
	}

	/**
	 * @param confirmTime the confirmTime to set
	 */
	public void setConfirmTime(int confirmTime) {
		this.confirmTime = confirmTime;
	}

	/**
	 * @return the payTime
	 */
	public int getPayTime() {
		return payTime;
	}

	/**
	 * @param payTime the payTime to set
	 */
	public void setPayTime(int payTime) {
		this.payTime = payTime;
	}

	/**
	 * @return the shippingTime
	 */
	public int getShippingTime() {
		return shippingTime;
	}

	/**
	 * @param shippingTime the shippingTime to set
	 */
	public void setShippingTime(int shippingTime) {
		this.shippingTime = shippingTime;
	}

	/**
	 * @return the packId
	 */
	public int getPackId() {
		return packId;
	}

	/**
	 * @param packId the packId to set
	 */
	public void setPackId(int packId) {
		this.packId = packId;
	}

	/**
	 * @return the cardId
	 */
	public int getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the bonusId
	 */
	public int getBonusId() {
		return bonusId;
	}

	/**
	 * @param bonusId the bonusId to set
	 */
	public void setBonusId(int bonusId) {
		this.bonusId = bonusId;
	}

	/**
	 * @return the invoiceNo
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * @return the extensionCode
	 */
	public String getExtensionCode() {
		return extensionCode;
	}

	/**
	 * @param extensionCode the extensionCode to set
	 */
	public void setExtensionCode(String extensionCode) {
		this.extensionCode = extensionCode;
	}

	/**
	 * @return the extensionId
	 */
	public int getExtensionId() {
		return extensionId;
	}

	/**
	 * @param extensionId the extensionId to set
	 */
	public void setExtensionId(int extensionId) {
		this.extensionId = extensionId;
	}

	/**
	 * @return the toBuyer
	 */
	public String getToBuyer() {
		return toBuyer;
	}

	/**
	 * @param toBuyer the toBuyer to set
	 */
	public void setToBuyer(String toBuyer) {
		this.toBuyer = toBuyer;
	}

	/**
	 * @return the payNote
	 */
	public String getPayNote() {
		return payNote;
	}

	/**
	 * @param payNote the payNote to set
	 */
	public void setPayNote(String payNote) {
		this.payNote = payNote;
	}

	/**
	 * @return the agencyId
	 */
	public int getAgencyId() {
		return agencyId;
	}

	/**
	 * @param agencyId the agencyId to set
	 */
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	/**
	 * @return the invType
	 */
	public String getInvType() {
		return invType;
	}

	/**
	 * @param invType the invType to set
	 */
	public void setInvType(String invType) {
		this.invType = invType;
	}

	/**
	 * @return the tax
	 */
	public BigDecimal getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	/**
	 * @return the isSeparate
	 */
	public int getIsSeparate() {
		return isSeparate;
	}

	/**
	 * @param isSeparate the isSeparate to set
	 */
	public void setIsSeparate(int isSeparate) {
		this.isSeparate = isSeparate;
	}

	/**
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the discount
	 */
	public BigDecimal getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
    
    

}
