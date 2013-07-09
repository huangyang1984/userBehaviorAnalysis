package net.ufida.info.login.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import net.ufida.info.login.model.SystemUser;
import net.ufida.x27.util.hibernate.BaseManager;

public class SystemUserManager extends BaseManager {

	public Class getModelClass() {
		return SystemUser.class;
	}

	public List getSystemRoles(String userId) {
		DetachedCriteria dc = super.getDetachedCriteria();
		dc.add(Restrictions.eq("account", userId));
		
		return super.findList(dc);
	}
}
