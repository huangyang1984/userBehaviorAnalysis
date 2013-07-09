/**
 * 
 */
package net.ufida.info.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

/**
 * @author Steven.yang
 *
 */
public class CategoryUtil {

	/**
	 * 获取根节点Id
	 * @param catId
	 * @param paramsMap
	 * @return
	 */
	public static int getParentId(int catId, Map<Integer,Integer> paramsMap){
		while(true){
			if(!paramsMap.get(catId).equals(0)){
				catId = (Integer) paramsMap.get(catId);
			}else{
				return catId;
			}
		}
	}
	
   
	/**
	 * 判断该商品分类Id是否与目标Id为相关路径
	 * @param catId
	 * @param desId
	 * @param paramsMap
	 * @return
	 */
   public static String getDestinctCategory(int catId ,int desId,Map<Integer,Integer> paramsMap){
	   if(paramsMap.get(catId).equals(0)){
		   return catId + "";
	   }else{
		   catId = paramsMap.get(catId);
		   if(catId == desId) return "ok";
		   else {
			   return getDestinctCategory(catId,desId, paramsMap);
		   }
	   }
   }
   
   public static void main(String[] args){
	   Map<Integer,Integer> paramsMap = new HashMap<Integer,Integer>();
	   paramsMap.put(198, 196);
	   paramsMap.put(197, 196);
	   paramsMap.put(212, 198);
	   paramsMap.put(213, 197);
	   paramsMap.put(196, 0);
	   
	   String catId = getDestinctCategory(213,196,paramsMap);
	   System.out.println(catId);
	   
   }
}
