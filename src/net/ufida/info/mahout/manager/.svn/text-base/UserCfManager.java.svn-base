package net.ufida.info.mahout.manager;

import java.util.ArrayList;
import java.util.List;

import net.ufida.info.mahout.model.RecommenderComputerResult;
import net.ufida.info.mahout.model.BasicRemmenderModel;
import net.ufida.info.util.RecommendationAlgorithmManager;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class UserCfManager extends RecommendationAlgorithmManager{

	@Override
	public Class getModelClass() {
		return BasicRemmenderModel.class;
	}
	
	public List<RecommenderComputerResult> getPriorityListByUserId(long userId,int count){
		try {
			List<RecommenderComputerResult> rsList = new ArrayList<RecommenderComputerResult>();
			List<RecommendedItem> recommendations = this.computerWithUserCf(count).recommend(userId, count); //按客户返回所需数目的推荐列表
		/*	for(RecommendedItem recommendedItem : recommendations){
				System.out.println(recommendedItem.getItemID());
			}*/
			
			if(recommendations != null && recommendations.size() != 0){
				for(int i=0;i<recommendations.size();i++){
					RecommenderComputerResult recommenderComputerResult = new RecommenderComputerResult();
					recommenderComputerResult.setPriority(recommendations.get(i).getValue());
					recommenderComputerResult.setProductId(recommendations.get(i).getItemID());
					rsList.add(recommenderComputerResult);
				}
				return rsList;
			}else{
                 return null;				
			}
		} catch (TasteException e) {
//			e.printStackTrace();
			return null;
		} 
	}

}
