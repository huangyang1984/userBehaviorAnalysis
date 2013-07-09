/**
 * 
 */
package net.ufida.info.mahout.manager;

import net.ufida.info.mahout.model.OrderGoods;
import net.ufida.x27.util.hibernate.BaseManager;

/**
 * @author Steven.yang
 *
 */
public class OrderGoodsManager  extends BaseManager{

	@Override
	public Class getModelClass() {
		return OrderGoods.class;
	}

}
