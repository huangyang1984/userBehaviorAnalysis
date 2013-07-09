package net.ufida.commons.listener;
/*
 * @(#)SessionListener.java	1.00	2009/02/20
 * CopyRight(C) stephen(zhoujianqiang AT gmail DOT com) 2009-2014, All rights reserved.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * session监听器. <br>
 * 在WEB容器的web.xml中添加本监听器的调用,具体格式如下：(其中的"[","]"分别用" <",">"替换) <br>
 * 
 * <pre>
 * 
 *    [web-app]
 *    [filter]
 *    ...
 *    [/filter]
 *    [filter-mapping]
 *    ...
 *    [/filter-mapping]
 *    ...
 *    [listener][listener-class]com.stephen.filter.SessionListener[/listener-class][/listener]
 *    ...
 *    [servlet]
 *    ...
 *    [/servlet]
 *    ...
 *    [/web-app]
 *  
 * </pre>
 * 
 * 注意在web.xml中配置的位置. <br>
 * 
 * @author stephen
 * @version 1.00
 * @see javax.servlet.http.HttpSessionAttributeListener
 */
public class SessionListener implements HttpSessionListener {
	private static final Logger log=Logger.getLogger(SessionListener.class); 
	/**
	 * 定义监听的session属性名.
	 */
	public final static String LISTENER_NAME = "_login";
	
	/**
	 * 定义存储客户登录session的集合.
	 */
	private static List<HttpSession> sessions = new ArrayList<HttpSession>();
	
//	private static List<SysUser> sysusers = new ArrayList<SysUser>();
	
	private static Map<String, HttpSession> map = new HashMap<String, HttpSession>();
	
	public static ServletContext sc = null;


	/**
	 * 返回客户登录session的集合.
	 * 
	 * @return
	 */
	public static List<HttpSession> getSessions() {
		return sessions;
	}
	
//	public static List<SysUser> getSysUsers(){
//		return sysusers;
//	}

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
		
//		HttpSession hs = sbe.getSession();
//		//SysUser suser = (SysUser)hs.getAttribute(LISTENER_NAME);
//		SysUser suser = (SysUser) hs.getValue(LISTENER_NAME);
//		if(suser!=null){
//			log.info(suser.getUsername());
//		}
//		String[] str = hs.getValueNames();
//		for(int i = 0; i<str.length; i++){
//			log.info("~~~~~~~~~~~hs.getValueNames();~~~~~~~~~~"+str[i]);
//			if (LISTENER_NAME.equals(str[i])){
//				map.remove(suser.getUsername());
//			}
//		}
//		
//		try {
//			WebApplicationContext wa = WebApplicationContextUtils.getWebApplicationContext(hs.getServletContext());
//			LoginService loginService = (LoginService)wa.getBean("loginService");
//			if(suser!=null){
//				loginService.logout(suser.getUsername());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		/*System.out.println("~~~~~~~~~~~!!!!!~~~~~~~~~~"+sbe.getSource().toString());
		String[] str = hs.getValueNames();
		for(int i = 0; i<str.length; i++){
			System.out.println("~~~~~~~~~~~hs.getValueNames();~~~~~~~~~~"+str[i]);
		}
		Enumeration en = hs.getAttributeNames();
		for(int i = 0; en.hasMoreElements();i ++){
			System.out.println("~~~~~~~~~~hs.getAttributeNames();~~~~~~~~"+en.nextElement().toString());
		}
		System.out.println("~~~~~hs.getId()~~~~~~~~~~~"+hs.getId());*/
		
	}
	
}

