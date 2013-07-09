/**
 * 
 */
package net.ufida.info.mahout.service;

import java.util.List;

import net.ufida.info.mahout.model.Category;
import net.ufida.info.mahout.model.OrderGoods;
import net.ufida.info.mahout.model.RecommenderComputerResult;

/**
 * @author Steven.yang
 *
 */
public interface UserCfService {
	
     public void getUnprocessedDataAndWriteToDat();
	 
	 public List<RecommenderComputerResult>  getPriorityListByUserId(long userId,int count);
	 
	 public OrderGoods getGoodsMsgById(int goodsId);
	 
	 public Category getCatNameByCatId(int catId);


}
