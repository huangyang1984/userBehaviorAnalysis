package net.ufida.info.common.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import net.ufida.info.login.model.SystemUser;

import org.apache.log4j.Logger;

public class SessionListener implements HttpSessionListener {
	private static final Logger log=Logger.getLogger(SessionListener.class); 
	
	/**
	 * 定义监听的session属性名.
	 */
	public final static String LISTENER_NAME = "_login";
	
	/**
	 * 定义存储用户登录session的集合.
	 */
	private static List<HttpSession> sessions = new ArrayList<HttpSession>();
	
	private static List<SystemUser> sysusers = new ArrayList<SystemUser>();
	
	private static Map<String, HttpSession> map = new HashMap<String, HttpSession>();
	
	public static ServletContext sc = null;
	
	public static List<HttpSession> getSessions() {
		return sessions;
	}

	public static List<SystemUser> getSysusers() {
		return sysusers;
	}

	public static Map<String, HttpSession> getMap() {
		return map;
	}

	/**
	 * 加入session时的监听方法.
	 * 
	 * @param HttpSessionEvent
	 *            session事件
	 */
	public void sessionCreated(HttpSessionEvent sbe) {
		if(sc==null){
			sc = sbe.getSession().getServletContext();
			System.out.println("上下文已经持久化在内存中,请放心使用!");
		}
		log.info("创建session:"+sbe.getSession());
	}

	/**
	 * session失效时的监听方法.
	 * 
	 * @param HttpSessionEvent
	 *            session事件
	 */
	public void sessionDestroyed(HttpSessionEvent sbe) {
		HttpSession hs = sbe.getSession();
		SystemUser suser = (SystemUser) hs.getValue(LISTENER_NAME);
		if(suser!=null){
			log.info(suser.getName());
		}
		String[] str = hs.getValueNames();
		for(int i = 0; i<str.length; i++){
			log.info("~~~~~~~~~~~hs.getValueNames();~~~~~~~~~~"+str[i]);
			if (LISTENER_NAME.equals(str[i])){
				map.remove(suser.getName());
			}
		}
		//留下以后做登出操作
		/*try {
			WebApplicationContext wa = WebApplicationContextUtils.getWebApplicationContext(hs.getServletContext());
			LoginService loginService = (LoginService)wa.getBean("loginService");
			if(suser!=null){
				loginService.logout(suser.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

}
