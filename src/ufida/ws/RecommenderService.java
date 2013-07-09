package ufida.ws;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ufida.info.mahout.common.CachingRecommender;
import net.ufida.info.mahout.common.MemoryDiffStorage;
import net.ufida.info.mahout.model.KGoods;
import net.ufida.info.mahout.model.RecommenderComputerResult;
import net.ufida.info.mahout.service.SlopeOneService;
import net.ufida.info.util.CategoryUtil;
import net.ufida.info.util.StringUtil;

import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.common.Weighting;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.slopeone.DiffStorage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 供电商外部调用webService接口
 * @author Steven.yang
 *
 */
public class RecommenderService {
	private static final Logger logger = Logger.getLogger(RecommenderService.class);
	
	private static Map<String,List> paramsMap = new HashMap<String,List>();
	
	private static final String fileDataModelSetPath = "/opt/ufda/data/mahoutRask/data.dat";
	
	private static final long fileModifyOriTime = new File(fileDataModelSetPath).lastModified();
	
	//推荐接口
	@SuppressWarnings("unused")
	public static List<RecommenderComputerResult> getRecommendData(long userId,int count){
		logger.info("++++++++++++++++ getRecommendData process +++++++++++++++++++++++++");
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		DataModel model;
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml"); 
		SlopeOneService slopeOneService = (SlopeOneService) ac.getBean("slopeOneService");
	    
		
		try {
			File file = new File(fileDataModelSetPath);
			long length1 = file.lastModified();
			model = new FileDataModel(file);
			DiffStorage diffStorage = new MemoryDiffStorage(model, Weighting.UNWEIGHTED, Long.MAX_VALUE);
			Recommender recommender = new CachingRecommender(new SlopeOneRecommender(model, Weighting.UNWEIGHTED, Weighting.UNWEIGHTED, diffStorage));  
			List<RecommenderComputerResult> rsList = new ArrayList<RecommenderComputerResult>();

			//通过文件大小判断是否重新写过模型文件
		    if(paramsMap.containsKey(userId + "-" + count)){
		    		//判断文件是否增量写过
		    		if(length1 != fileModifyOriTime){
		    			logger.info("######################## 文件数据发生变动，重新计算推荐引擎数据 #########################");
		    			recommendations = recommender.recommend(userId, count);
		    		}else{
		    			recommendations = paramsMap.get(userId + "-" + count);
		    		}
		    }else{
		    	if(recommender != null){
		    		try {
		    			logger.info("######################## 新用户数据推荐 #########################");
						recommendations = recommender.recommend(userId, count);
					} catch (TasteException e) {
					    recommendations = null;	
					} 
		    		//按客户返回所需数目的推荐列表
		    		paramsMap.put(userId + "-" + count, recommendations);	
		    	}else{
		    		//默认推荐数据
		    	}
		    }
		    
            if(recommendations  != null){
            	for(int i=0;i<recommendations.size();i++){
            		RecommenderComputerResult slopeOneComputerResult = new RecommenderComputerResult();
            		slopeOneComputerResult.setPriority(recommendations.get(i).getValue());
            		slopeOneComputerResult.setProductId(recommendations.get(i).getItemID());
            		rsList.add(slopeOneComputerResult);
            	}
            }else{
                rsList = null;            	
            }

 			if(rsList != null){
				for(int i=0;i<rsList.size();i++){
					KGoods kGoods = slopeOneService.getKGoodsMsgById((int)rsList.get(i).getProductId());
//					Category  categoryMsg = slopeOneService.getCatNameByCatId(kGoods.getCatId());
					rsList.get(i).setGoodsName(kGoods.getGoodsName());
					rsList.get(i).setCatId(kGoods.getCatId());
//					rsList.get(i).setCatName(categoryMsg.getCatName());
				}
			}
			return rsList;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TasteException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	//推荐接口二次过滤
	@SuppressWarnings("unused")
	public static List<RecommenderComputerResult> getRecommendDataSubFilter(long userId,int count,int catId){
		logger.info("++++++++++++++++ getRecommendData process Sub Filter +++++++++++++++++++++++++");
		DataModel model;
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-context.xml"); 
		SlopeOneService slopeOneService = (SlopeOneService) ac.getBean("slopeOneService");
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		
		try {
			File file = new File(fileDataModelSetPath);
			long length1 = file.lastModified();
			model = new FileDataModel(file);
			DiffStorage diffStorage = new MemoryDiffStorage(model, Weighting.UNWEIGHTED, Long.MAX_VALUE);
			Recommender recommender = new CachingRecommender(new SlopeOneRecommender(model, Weighting.UNWEIGHTED, Weighting.UNWEIGHTED, diffStorage));  
			List<RecommenderComputerResult> rsList = new ArrayList<RecommenderComputerResult>();
			List<RecommenderComputerResult> rsList2 = new ArrayList<RecommenderComputerResult>(rsList.size());
			Map<Integer,Integer> categoryMap = slopeOneService.getParamsMapFromCategory();
			
		    if(paramsMap.containsKey(userId + "-" + count)){
		    	if(length1 != fileModifyOriTime){
		    		logger.info("######################## 文件数据发生变动，重新计算推荐引擎数据 #########################");
	    			recommendations = recommender.recommend(userId, count);
	    		}else{
	    			recommendations = paramsMap.get(userId + "-" + count);
	    		}
		    }else{
		    	if(recommender != null){
		    		try {
		    			logger.info("######################## 新用户数据推荐 #########################");
						recommendations = recommender.recommend(userId, count);
					} catch (TasteException e) {
					    recommendations = null;	
					} 
		    		//按客户返回所需数目的推荐列表
		    		paramsMap.put(userId + "-" + count, recommendations);	
		    	}else{
		    		//默认推荐数据
		    	}
		    }
			    
            if(recommendations  != null){
            	for(int i=0;i<recommendations.size();i++){
            		RecommenderComputerResult slopeOneComputerResult = new RecommenderComputerResult();
            		slopeOneComputerResult.setPriority(recommendations.get(i).getValue());
            		slopeOneComputerResult.setProductId(recommendations.get(i).getItemID());
            		rsList.add(slopeOneComputerResult);
            	}
            }else{
                rsList = null;            	
            }
			
			if(rsList != null){
				for(int i=0;i<rsList.size();i++){
					KGoods kGoods = slopeOneService.getKGoodsMsgById((int)rsList.get(i).getProductId());
					rsList.get(i).setGoodsName(kGoods.getGoodsName());
					rsList.get(i).setCatId(kGoods.getCatId());
				}
				
				for(int i=0;i<rsList.size();i++){
//					if(categoryMap.get(catId) == 0){
//						StringUtil.copyByAdd(rsList, rsList2);  
//						break;
//					}else {
					
					if(rsList.get(i).getCatId() == catId){
						rsList2.add(rsList.get(i));
					}else{
						if(categoryMap.get(rsList.get(i).getCatId()) == catId) {
							rsList2.add(rsList.get(i));
						}else{
							if(CategoryUtil.getDestinctCategory(rsList.get(i).getCatId(), catId, categoryMap).equals("ok")){
								rsList2.add(rsList.get(i));
							}
						}
					}
				}
			}else{
				rsList2 = null;
			}
			return rsList2;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TasteException e) {
			e.printStackTrace();
		}
        return null;
	}
	

}
