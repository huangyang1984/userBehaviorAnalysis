/**
 * 
 */
package net.ufida.info.mahout.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ufida.info.mahout.model.KGoods;
import net.ufida.info.mahout.model.RecommenderComputerResult;
import net.ufida.info.mahout.service.SlopeOneService;
import net.ufida.info.util.CategoryUtil;
import net.ufida.info.util.StringUtil;
import net.ufida.x27.util.web.BaseCtrl;
import net.ufida.x27.util.web.CtrlUtils;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Steven.yang
 * 基于slopeOne推荐控制器
 */
public class SlopeOneCtrl extends BaseCtrl {

	private static final Logger log = Logger.getLogger(SlopeOneCtrl.class);
	
	private SlopeOneService slopeOneService;
	
	private static final String PATH = "pages/slopeOne";

	public void setSlopeOneService(SlopeOneService slopeOneService) {
		this.slopeOneService = slopeOneService;
	}
	
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res) {
		/**
		 * 从数据库获取原始数据并写入dat
		 */
		slopeOneService.getUnprocessedDataAndWriteToDat();
		return CtrlUtils.getModelAndView(PATH, "slopeOne");
	}
	
	/**
	 * 基于slopeone的相似度计算
	 * @param req
	 * @param res
	 * @return
	 */
	public ModelAndView computerWithSlopeOne(HttpServletRequest req, HttpServletResponse res) {
		String userId = req.getParameter("userId"); 
		String count = req.getParameter("count");
		String catId = req.getParameter("catId");
		long computerId = Long.parseLong(userId);
		int selectCount = Integer.parseInt(count);
		int selectParentId = Integer.parseInt(catId);
		List<RecommenderComputerResult> rsList = slopeOneService.getPriorityListByUserId(computerId,selectCount);//获取指定用户所有的推荐记录
		Map<String,Object> map = new HashMap<String,Object>();
		
		Map<Integer,Integer> paramsMap = slopeOneService.getParamsMapFromCategory();
		
		if(rsList != null){
			List<RecommenderComputerResult> rsList2 = new ArrayList<RecommenderComputerResult>(rsList.size());
			for(int i=0;i<rsList.size();i++){
			/*	kgoods orderGoodsMsg = slopeOneService.getKGoodsMsgById((int)rsList.get(i).getProductId());
				Category  categoryMsg = slopeOneService.getCatNameByCatId(orderGoodsMsg.getCatId());
				rsList.get(i).setGoodsName(orderGoodsMsg.getGoodsName());
				rsList.get(i).setCatId(orderGoodsMsg.getCatId());
				rsList.get(i).setCatName(categoryMsg.getCatName());*/
				
				KGoods kGoods = slopeOneService.getKGoodsMsgById((int)rsList.get(i).getProductId());
//				Category  categoryMsg = slopeOneService.getCatNameByCatId(kGoods.getCatId());
				rsList.get(i).setGoodsName(kGoods.getGoodsName());
				rsList.get(i).setCatId(kGoods.getCatId());
			}
			
			
			/**
			 * 基于商品类别的二次过滤
			 */
			for(int i=0;i<rsList.size();i++){
				if(selectParentId == 0){
					StringUtil.copyByAdd(rsList, rsList2);  
					break;
				}else if(selectParentId == CategoryUtil.getParentId(rsList.get(i).getCatId(),paramsMap)){
					
					rsList2.add(rsList.get(i));
				}
			}
			
			map.put("rsList", rsList2);
			return CtrlUtils.getModelAndView(PATH, "slopeOne", map);
		}else{
			map.put("flag", "false");
			return CtrlUtils.getModelAndView(PATH, "slopeOne", map);
		}
		
	}
	
}
