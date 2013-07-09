package net.ufida.info.login.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import net.ufida.info.login.model.SystemRole;
import net.ufida.x27.util.hibernate.BaseManager;

public class SystemRoleManager extends BaseManager {

	public Class getModelClass() {
		return SystemRole.class;
	}

	/*public List getSystemRoles(String userId, String sysCode) {
		DetachedCriteria dc = super.getDetachedCriteria();
		dc.add(Restrictions.eq("pageTemplate.idStr", pageTemplateId));
	}*/
}
