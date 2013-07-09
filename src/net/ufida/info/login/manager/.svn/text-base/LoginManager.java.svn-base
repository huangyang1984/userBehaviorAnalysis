package net.ufida.info.login.manager;

import java.util.List;

import net.ufida.info.login.model.SystemMenu;
import net.ufida.info.login.model.SystemRole;
import net.ufida.x27.util.hibernate.BaseManager;

import org.hibernate.Query;

/**
 * 
 * @author Steven.yang
 *
 */
public class LoginManager extends BaseManager {

	public Class getModelClass() {
		return null;
	}

	public List getRoleMenuBySubsysroleid(String roleid) {
		
		StringBuilder hql = new StringBuilder("SELECT c.* FROM tb_subsys_role a LEFT JOIN tb_subsys_role_menu b ON ");
		hql.append("a.subsys_role_id = b.subsys_role_id LEFT JOIN tb_subsys_menu c ON ");
		hql.append("b.subsys_menu_id = c.subsys_menu_id WHERE a.subsys_role_id=");
		hql.append(roleid+" ORDER BY c.parent_id");
		
		Query qry = getSession().createQuery(hql.toString());
		List rsList = qry.list();
        /*Iterator iterator = (Iterator) rsList.iterator();
        if (iterator.hasNext()) {
        	
        }*/
		return rsList;
	}

	public SystemRole getSubSysRoleByUseridAndSyscode(String userid,
			String sysCode) {
		StringBuilder hql = new StringBuilder("SELECT b.* FROM tb_subsys_user_role a LEFT JOIN tb_subsys_role b ON ");
		hql.append("a.subsys_role_id = b.subsys_role_id WHERE a.sys_user_id=");
		hql.append(userid+" AND b.sys_code='").append(sysCode+"'");
		
		/*StringBuilder hql = new StringBuilder("SELECT c.* FROM tb_sys_user a LEFT JOIN tb_subsys_user_role b ON ");
		hql.append("a.SYS_USER_ID = b.sys_user_id LEFT JOIN tb_subsys_role c ON ");
		hql.append("b.subsys_role_id = c.subsys_role_id WHERE a.SYS_USER_ID=");
		hql.append(userid+" AND c.sys_code='").append(sysCode+"'");*/
		
		Query qry = getSession().createQuery(hql.toString());
		List rsList = qry.list();
		return (SystemRole) rsList.get(0);
	}

	public List getRoleMenuByUseridAndSyscode(String userid,
			String sysCode) {
//		System.out.println("fuck------------------------");
		/*StringBuilder hql = new StringBuilder("SELECT m FROM SystemUser as u LEFT JOIN SystemRole as r ");
		hql.append("JOIN SystemMenu as m WHERE u.idStr=:userId AND r.syscode=:sysCode");
		
		Query qry = getSession().createQuery(hql.toString());
		qry.setInteger("userId", Integer.parseInt(userid));
		qry.setString("sysCode", sysCode);
		
		List rsList = qry.list();*/
		
			
		StringBuilder sql = new StringBuilder("SELECT {c.*} FROM tb_subsys_user_role a LEFT JOIN tb_subsys_role_menu b ON ");
		sql.append("a.subsys_role_id = b.subsys_role_id LEFT JOIN tb_subsys_menu c ON ");
		sql.append("b.subsys_menu_id = c.subsys_menu_id WHERE a.sys_user_id=");
		sql.append(userid+" AND c.sys_code='").append(sysCode+"'");
		List rsList = getSession().createSQLQuery(sql.toString()).addEntity("c",SystemMenu.class).list();

		for (int i = 0; i < rsList.size(); i++) {
			SystemMenu sm = (SystemMenu) rsList.get(i);
//			System.out.println("-----------------"+sm.getName());
		}

		
		return rsList;
	}

}
