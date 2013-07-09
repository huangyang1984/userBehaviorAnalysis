/**
 * 
 */
package net.ufida.info.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ufida.info.mahout.common.MemoryDiffStorage;
import net.ufida.x27.util.hibernate.BaseManager;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.common.Weighting;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.slopeone.DiffStorage;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.hibernate.Query;

/**
 * @author Steven.yang
 *
 */
public abstract class RecommendationAlgorithmManager extends BaseManager{
	
	private static Map<String,Recommender> paramsMap = new HashMap<String, Recommender>();
	
	/**
	 * 获取基于192.168.100.213kshop的原始数据模型
	 */
	public void getUnprocessedDataFromKshop(){
		String sql = "select oi.user_id ,og.goods_id, og.goods_number, og.order_id " +
	                   " from k_order_goods og left join k_order_info oi on og.order_id=oi.order_id ";
		
		Query q = this.getSession().createSQLQuery(sql);
		
		StringBuffer sb=new StringBuffer();
		List result = q.list();       
		System.out.println(result.size());
		Iterator it = result.iterator();       
		
		try {
			while (it.hasNext()) {          
				Object[] tuple = (Object[]) it.next();         
				sb.append(tuple[0] + "," + tuple[1] + "," + tuple[2] + "\r\n");
			}     
			
			HDFSUtils.createFile("/mahoutRask/data.dat");
	        HDFSUtils.createAndWriteHdfsFile("/mahoutRask/data.dat",sb.toString());
//	        HDFSUtils.saveTmpFile(sb.toString());
	        HDFSUtils.getFile("/mahoutRask/data.dat", "/opt/ufda/data/mahoutRask/data.dat");  //download to local disk
		}catch (Exception e) {
			logger.info("******************* hadoop write error **************************");
		}
		
	}
	
	
	
	/**
	 * 获取待处理的原始数据模型
	 */
	public void getUnprocessedData() {
//		String sql = "select * from tmp_good_order limit 1000000";  //数据量控制调试
		
		String sql = "select oi.user_id ,og.goods_id, og.goods_number, og.order_id " +
                " from k_order_goods og left join k_order_info oi on og.order_id=oi.order_id ";
		
        //二次加载缓存读取
//		Query q = this.getSession().createSQLQuery(sql);
//		q.setCacheable(true);
//		List results = q.list();
//		
//		try {
//			/*BufferedWriter out = new BufferedWriter(new FileWriter("E:/data.dat"));
//	        for (int i = 0; i < results.size(); i++) {
//	        	SlopeOneRemmenderModel sm = (SlopeOneRemmenderModel) results.get(i);
//	            StringBuffer sb=new StringBuffer();
//	            sb.append(sm.getUserId() + "," + sm.getProductId() + "," + sm.getIndicator() + "\r\n");
//	            out.write(sb.toString());
//	        }        
//	        out.close();*/
//	        
//	        //write to hadoop with .dat file
//	        StringBuffer sb=new StringBuffer();
//	        for (int i = 0; i < results.size(); i++) {
//	        	BasicRemmenderModel sm = (BasicRemmenderModel) results.get(i);
//	            sb.append(sm.getUserId() + "," + sm.getProductId() + "," + sm.getIndicator() + "\r\n");
//	        }     、
		
		    Query q = this.getSession().createSQLQuery(sql);
			
			StringBuffer sb=new StringBuffer();
			List result = q.list();       
			System.out.println(result.size());
			Iterator it = result.iterator();       
			
			try {
				while (it.hasNext()) {          
					Object[] tuple = (Object[]) it.next();         
					sb.append(tuple[0] + "," + tuple[1] + "," + tuple[2] + "\r\n");
				}     

			//hadoop交互
	        HDFSUtils.createFile("/mahoutRask/data.dat");
	        HDFSUtils.createAndWriteHdfsFile("/mahoutRask/data.dat",sb.toString());
//	        HDFSUtils.saveTmpFile(sb.toString());
	        HDFSUtils.getFile("/mahoutRask/data.dat", "/opt/ufda/data/mahoutRask/data.dat");  //download to local disk
	        
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 基于slopeOne的相似度计算
	 * @return
	 * @throws TasteException 
	 */
	public Recommender computerWithSlopeOne(){
		 try {
			DataModel model = new FileDataModel(new File("/opt/ufda/data/mahoutRask/data.dat"));
			DiffStorage diffStorage = new MemoryDiffStorage(model, Weighting.UNWEIGHTED, Long.MAX_VALUE);
		    Recommender recommender = new SlopeOneRecommender(model, Weighting.UNWEIGHTED, Weighting.UNWEIGHTED, diffStorage);  
		    paramsMap.put("bankupRecommender", recommender);
			return recommender;
		} catch (TasteException e) {
			logger.info("##################### computer with slopeone failure ，get bankup recommender data ########################");
			Recommender recommenderBankUp =paramsMap.get("bankupRecommender");
			return null;
		} catch (IOException e) {
			logger.info("##################### write file failure ，get bankup recommender data ##########################");
			Recommender recommenderBankUp =paramsMap.get("bankupRecommender");
			return null;
		} 
	}
	
	/**
	 * 基于UserCf的相似度计算
	 * @return
	 */
	public Recommender computerWithUserCf(int count){
		try {
			DataModel model = new FileDataModel(new File("/opt/ufda/data/mahoutRask/data.dat"));
			UserSimilarity similarity=new PearsonCorrelationSimilarity(model);
			UserNeighborhood neighborhood=new NearestNUserNeighborhood(count,similarity,model); //对每个用户取固定数量N的最近邻居
//			double threshold = 1.0;
//			UserNeighborhood neighborhood2 = new ThresholdUserNeighborhood(threshold, similarity, model);
			Recommender recommender=new GenericUserBasedRecommender(model,neighborhood,similarity);
			return recommender;
		} catch (IOException e) {
			return null;
		} catch (TasteException e) {
            return null;
		}
	}
	
	public static void main(String[] args){
		 SimpleDateFormat   sDateFormat   =   new   SimpleDateFormat("yyyyMMdd");     
		 String   date   =   sDateFormat.format(new   java.util.Date());  
		 
		 Calendar   cal   =   Calendar.getInstance(); 
		 cal.add(Calendar.DATE,   -1); 
		 String   yesterday   =   new   SimpleDateFormat( "yyyyMMdd ").format(cal.getTime());
		 System.out.println(yesterday);
	}
	

}
