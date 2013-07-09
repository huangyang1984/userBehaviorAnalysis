/**
 * 
 */
package net.ufida.info.mahout.service;

import java.util.List;

import net.ufida.info.mahout.manager.CategoryManager;
import net.ufida.info.mahout.manager.OrderGoodsManager;
import net.ufida.info.mahout.manager.UserCfManager;
import net.ufida.info.mahout.model.Category;
import net.ufida.info.mahout.model.OrderGoods;
import net.ufida.info.mahout.model.RecommenderComputerResult;

/**
 * @author Steven.yang
 *
 */
public class UserCfServiceImpl implements UserCfService {
	
    private UserCfManager userCfManager;
	
	private OrderGoodsManager orderGoodsManager;
	
	private CategoryManager categoryManager;

	@Override
	public void getUnprocessedDataAndWriteToDat() {
		userCfManager.getUnprocessedData();
		
	}

	@Override
	public List<RecommenderComputerResult> getPriorityListByUserId(long userId,
			int count) {
		return userCfManager.getPriorityListByUserId(userId, count);
	}

	@Override
	public OrderGoods getGoodsMsgById(int goodsId) {
		return (OrderGoods) orderGoodsManager.findById(goodsId);
	}

	/**
	 * @return the userCfManager
	 */
	public UserCfManager getUserCfManager() {
		return userCfManager;
	}

	/**
	 * @param userCfManager the userCfManager to set
	 */
	public void setUserCfManager(UserCfManager userCfManager) {
		this.userCfManager = userCfManager;
	}

	/**
	 * @return the orderGoodsManager
	 */
	public OrderGoodsManager getOrderGoodsManager() {
		return orderGoodsManager;
	}

	/**
	 * @param orderGoodsManager the orderGoodsManager to set
	 */
	public void setOrderGoodsManager(OrderGoodsManager orderGoodsManager) {
		this.orderGoodsManager = orderGoodsManager;
	}

	@Override
	public Category getCatNameByCatId(int catId) {
		return (Category) categoryManager.findById(catId);
	}

	/**
	 * @return the categoryManager
	 */
	public CategoryManager getCategoryManager() {
		return categoryManager;
	}

	/**
	 * @param categoryManager the categoryManager to set
	 */
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
	

}
