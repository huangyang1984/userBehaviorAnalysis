/**
 * 
 */
package net.ufida.info.mahout.manager;

import net.ufida.info.mahout.model.Category;
import net.ufida.x27.util.hibernate.BaseManager;

/**
 * @author Steven.yang
 *
 */
public class CategoryManager  extends BaseManager{

	@Override
	public Class getModelClass() {
		return Category.class;
	}

}
