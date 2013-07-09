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

import net.ufida.info.mahout.model.Category;
import net.ufida.info.mahout.model.OrderGoods;
import net.ufida.info.mahout.model.RecommenderComputerResult;
import net.ufida.info.mahout.service.UserCfService;
import net.ufida.info.util.StringUtil;
import net.ufida.x27.util.web.BaseCtrl;
import net.ufida.x27.util.web.CtrlUtils;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Steven.yang
 * 基于UserCf的推荐控制器
 */
public class UserCfCtrl extends BaseCtrl{
	private static final Logger log = Logger.getLogger(UserCfCtrl.class);
	
	private UserCfService userCfService;
	
	private static final String PATH = "pages/usercf";

	public void setUserCfService(UserCfService userCfService) {
		this.userCfService = userCfService;
	}
	
	public ModelAndView process(HttpServletRequest req, HttpServletResponse res) {
		userCfService.getUnprocessedDataAndWriteToDat();
		return CtrlUtils.getModelAndView(PATH, "userCf");
	}
	
	public ModelAndView computerWithUserCf(HttpServletRequest req, HttpServletResponse res) {
		String userId = req.getParameter("userId"); 
		String count = req.getParameter("count");
		String catId = req.getParameter("catId");
		long computerId = Long.parseLong(userId);
		int selectCount = Integer.parseInt(count);
		int selectCatId = Integer.parseInt(catId);
		List<RecommenderComputerResult> rsList = userCfService.getPriorityListByUserId(computerId,selectCount);
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(rsList != null){
			List<RecommenderComputerResult> rsList2 = new ArrayList<RecommenderComputerResult>(rsList.size());
			for(int i=0;i<rsList.size();i++){
				OrderGoods orderGoodsMsg = userCfService.getGoodsMsgById((int)rsList.get(i).getProductId());
				Category  categoryMsg = userCfService.getCatNameByCatId(orderGoodsMsg.getCatId());
				rsList.get(i).setGoodsName(orderGoodsMsg.getGoodsName());
				rsList.get(i).setCatId(orderGoodsMsg.getCatId());
				rsList.get(i).setCatName(categoryMsg.getCatName());
			}
			
			/**
			 * 基于商品类别的二次过滤
			 */
			for(int i=0;i<rsList.size();i++){
				if(selectCatId == 0){
					StringUtil.copyByAdd(rsList, rsList2);  
					break;
				}else if(rsList.get(i).getCatId() == selectCatId){
					rsList2.add(rsList.get(i));
				}
			}
			map.put("rsList", rsList2);
			return CtrlUtils.getModelAndView(PATH, "userCf", map);
		}else{
			map.put("flag", "false");
			return CtrlUtils.getModelAndView(PATH, "userCf", map);
		}
	}
}
