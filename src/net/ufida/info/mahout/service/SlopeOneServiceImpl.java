/**
 * 
 */
package net.ufida.info.mahout.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ufida.info.mahout.manager.CategoryManager;
import net.ufida.info.mahout.manager.KCategoryManager;
import net.ufida.info.mahout.manager.KGoodsManager;
import net.ufida.info.mahout.manager.OrderGoodsManager;
import net.ufida.info.mahout.manager.SlopeOneManager;
import net.ufida.info.mahout.model.Category;
import net.ufida.info.mahout.model.KCategory;
import net.ufida.info.mahout.model.KGoods;
import net.ufida.info.mahout.model.OrderGoods;
import net.ufida.info.mahout.model.RecommenderComputerResult;

/**
 * @author Steven.yang
 * 
 */
public class SlopeOneServiceImpl implements SlopeOneService {

	private SlopeOneManager slopeOneManager;

	private OrderGoodsManager orderGoodsManager;

	private CategoryManager categoryManager;

	private KGoodsManager kGoodsManager;

	private KCategoryManager kCategoryManager;

	public void setSlopeOneManager(SlopeOneManager slopeOneManager) {
		this.slopeOneManager = slopeOneManager;
	}

	@Override
	public void getUnprocessedDataAndWriteToDat() {

		slopeOneManager.getUnprocessedData();
	}

	/**
	 * @return the orderGoodsManager
	 */
	public OrderGoodsManager getOrderGoodsManager() {
		return orderGoodsManager;
	}

	/**
	 * @param orderGoodsManager
	 *            the orderGoodsManager to set
	 */
	public void setOrderGoodsManager(OrderGoodsManager orderGoodsManager) {
		this.orderGoodsManager = orderGoodsManager;
	}

	/**
	 * @return the slopeOneManager
	 */
	public SlopeOneManager getSlopeOneManager() {
		return slopeOneManager;
	}

	@Override
	public List<RecommenderComputerResult> getPriorityListByUserId(long userId,
			int count) {
		return slopeOneManager.getPriorityListByUserId(userId, count);
	}

	@Override
	public OrderGoods getGoodsMsgById(int goodsId) {
		return (OrderGoods) orderGoodsManager.findById(goodsId);
	}

	/**
	 * @return the categoryManager
	 */
	public CategoryManager getCategoryManager() {
		return categoryManager;
	}

	/**
	 * @param categoryManager
	 *            the categoryManager to set
	 */
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

	@Override
	public Category getCatNameByCatId(int catId) {
		return (Category) categoryManager.findById(catId);
	}

	@Override
	public KGoods getKGoodsMsgById(int goodsId) {
		return (KGoods) kGoodsManager.findById(goodsId);
	}

	/**
	 * @return the kGoodsManager
	 */
	public KGoodsManager getkGoodsManager() {
		return kGoodsManager;
	}

	/**
	 * @param kGoodsManager
	 *            the kGoodsManager to set
	 */
	public void setkGoodsManager(KGoodsManager kGoodsManager) {
		this.kGoodsManager = kGoodsManager;
	}

	@Override
	public Map<Integer, Integer> getParamsMapFromCategory() {
		List rsList = kCategoryManager.findList();
		Map<Integer,Integer> paramsMap = new HashMap<Integer,Integer>();
		for(int i=0;i<rsList.size();i++){
			KCategory kCategory = (KCategory) rsList.get(i);
			paramsMap.put(kCategory.getCatId(), kCategory.getParentId());
		}
		
		return paramsMap;
	}

	/**
	 * @return the kCategoryManager
	 */
	public KCategoryManager getkCategoryManager() {
		return kCategoryManager;
	}

	/**
	 * @param kCategoryManager the kCategoryManager to set
	 */
	public void setkCategoryManager(KCategoryManager kCategoryManager) {
		this.kCategoryManager = kCategoryManager;
	}

}
