package net.ufida.info.login.manager;

import java.util.List;

import net.ufida.info.login.model.SystemMenu;
import net.ufida.x27.util.hibernate.BaseManager;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class SystemMenuManager extends BaseManager {

	public Class getModelClass() {
		return SystemMenu.class;
	}

	public List getSystemMenus(String sysCode){
		DetachedCriteria dc = super.getDetachedCriteria();
		dc.add(Restrictions.eq("syscode", sysCode));
		
		return super.findList(dc);
	}
}
