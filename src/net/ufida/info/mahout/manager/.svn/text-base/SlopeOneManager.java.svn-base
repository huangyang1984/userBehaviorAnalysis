/**
 * 
 */
package net.ufida.info.mahout.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ufida.info.mahout.model.BasicRemmenderModel;
import net.ufida.info.mahout.model.RecommenderComputerResult;
import net.ufida.info.util.RecommendationAlgorithmManager;

import org.apache.commons.betwixt.digester.AddDefaultsRule;
import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

/**
 * @author Steven.yang
 * sloneOne 数据交互层
 */
public class SlopeOneManager extends RecommendationAlgorithmManager {
	
	private static final Logger logger = Logger.getLogger(SlopeOneManager.class);
	private static Map<String,List> paramsMap = new HashMap<String, List>();

	/* (non-Javadoc)
	 * @see net.ufida.x27.util.hibernate.BaseManager#getModelClass()
	 */
	@Override
	public Class getModelClass() {
		return BasicRemmenderModel.class;
	}
		
	/**
	 * 基于slopeOne算法的推荐优先级列表
	 * @param userId
	 * @param count
	 * @return
	 */
	public List<RecommenderComputerResult> getPriorityListByUserId(long userId,int count){
		try {
			List<RecommenderComputerResult> rsList = new ArrayList<RecommenderComputerResult>();
			List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
	
			//如果传入的userIdea和Count已经获取过，则直接从hashmap加载
		    if(paramsMap.containsKey(userId + "-" + count)){
		    	recommendations = paramsMap.get(userId + "-" + count);
		    }else{
		    	Recommender recommender = this.computerWithSlopeOne();
		    	if(recommender != null){
		    		recommendations = recommender.recommend(userId, count); //按客户返回所需数目的推荐列表
		    		paramsMap.put(userId + "-" + count, recommendations);	
		    	}else{
		    		//默认推荐位数据
		    		recommendations = null;
		    	}
		    }

		    if(recommendations != null){
		    	for(int i=0;i<recommendations.size();i++){
		    		RecommenderComputerResult slopeOneComputerResult = new RecommenderComputerResult();
		    		slopeOneComputerResult.setPriority(recommendations.get(i).getValue());
		    		slopeOneComputerResult.setProductId(recommendations.get(i).getItemID());
		    		rsList.add(slopeOneComputerResult);
		    	}
		    }else{
		    	rsList =  null;
		    }
		    
			return rsList;
		} catch (TasteException e) {
//			e.printStackTrace();
			logger.info("####################### 无相关用户数据 *********************");
			return null;
		} 
	}
	

}
