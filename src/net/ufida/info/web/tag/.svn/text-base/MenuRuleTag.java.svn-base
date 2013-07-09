package net.ufida.info.web.tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import net.ufida.info.login.model.SystemMenu;
import net.ufida.info.login.service.LoginService;
import net.ufida.x27.util.web.BaseTag;
import net.ufida.x27.util.web.TagUtils;

import org.apache.commons.lang.StringUtils;

/**
 * 菜单列表标签
 *
 */
public class MenuRuleTag extends BaseTag {
	//用户id
	private String userid;
	
	//系统代码
	private String SysCode;
	
	//角色id
	private String roleid;
	
	//css类
	private String classStyleLi;
	
	//css类
	private String classStyleLiA;
	
	//css类
	private String classStyleUl;
	
	/** 登陆服务类 */
	private LoginService loginService;
	
	/*为啥这个setter注入不行
	 * public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}*/
	
	public int doStartTag() {
        return super.EVAL_BODY_INCLUDE;
    }
    
    public int doEndTag() {
    	//获取关联系统菜单
//    	if (loginService == null) {
//    		loginService = (LoginService)getWebApplicationContext().getBean("loginService");
//    	}
//    	System.out.println(this.userid+"==========="+this.SysCode);
//    	List<SystemMenu> smList = loginService.getRoleMenuByUseridAndSyscode(this.userid, this.SysCode);
    	//loginService.getRoleMenuBySubsysroleid(roleid);
    	//菜单序列化
//    	List<SystemMenu> list = loginService.getSortMenuTree(smList);
    	
    	StringBuilder sb = new StringBuilder();
    	//组织li标签(循环1级菜单)
//    	for(int i =0; i < list.size(); i++){
    		sb.append("<li class = \"").append(this.classStyleLi).append("\">").
    		append("<a href = \"#\" class = \"").append(this.classStyleLiA).
    		append("\" id=\"himenu").append(1).append("Actuator\">").
    		append("test").append("</a>").append("<ul class=\"").
    		append(this.classStyleUl).append("\" id=\"himenu").append(1).append("Menu\">").
    		append("<li><a target=\"main\" href=\"").append("test.do"+"\" title=\"").
    		append("test"+"\">").append("test"+"</a></li>").append("</ul>").append("</li>");
//    	
//    		Iterator<SystemMenu> it = list.get(i).getItems().iterator();
//    		while (it.hasNext()) {
//    			SystemMenu p = it.next();
//    			sb.append("<li><a target=\"main\" href=\"").append(p.getLink()+"\" title=\"").
//    			append(p.getName()+"\">").append(p.getName()+"</a></li>");
//    		}
//    		sb.append("</ul>").append("</li>");
//    	}
    	
        TagUtils.pageContextWrite(pageContext, sb.toString());
        return super.EVAL_PAGE;
    }

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setSysCode(String sysCode) {
		SysCode = sysCode;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public void setClassStyleLi(String classStyleLi) {
		this.classStyleLi = classStyleLi;
	}

	public void setClassStyleLiA(String classStyleLiA) {
		this.classStyleLiA = classStyleLiA;
	}

	public void setClassStyleUl(String classStyleUl) {
		this.classStyleUl = classStyleUl;
	}

	
}
