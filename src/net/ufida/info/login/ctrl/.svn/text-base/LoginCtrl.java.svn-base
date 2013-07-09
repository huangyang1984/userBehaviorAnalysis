package net.ufida.info.login.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ufida.info.common.listener.SessionListener;
import net.ufida.info.login.model.SystemUser;
import net.ufida.info.login.service.LoginService;
import net.ufida.x27.util.web.BaseCtrl;
import net.ufida.x27.util.web.CtrlUtils;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Steven.yang
 *
 */
public class LoginCtrl extends BaseCtrl {
	/** 记录当前对象的日志 */
	private static final Logger log = Logger.getLogger(LoginCtrl.class);

	/** 登陆页面路径 */
	private static final String PATH = "";

	/** 登陆服务类 */
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
			Map map = new HashMap(0);
			String username = "";
			String password = "";
			try {
				// 获取输入的账户和密码
				username = CtrlUtils.getStrAndPutInMap(req, "j_username", "",
						map);
				password = CtrlUtils.getStrAndPutInMap(req, "j_password", "",
						map);
				// 检测是否正确的账户和对应密码——可扩展成返回具体信息
//				int check = loginService.checkLogin(username, password);
				int check = 3;
				String errormessage = "";
				if (check == 3) {
					// 进入
					SystemUser systemUser = new SystemUser();
					systemUser.setName("ufida");
					systemUser.setIdStr(1);
					req.getSession().setAttribute(
							SessionListener.LISTENER_NAME,
							systemUser);
					res.sendRedirect("index.jsp");
//					return new ModelAndView("index", map);
					return null;
				} else if (check == 0) {
					errormessage = "此用户不存在！";
				} else if (check == 1) {
					errormessage = "用户名重名！";
				} else if (check == 2) {
					errormessage = "此用户已被关闭！";
				} else if (check == 4) {
					errormessage = "密码输入错误！";
				}

				// 返回登陆页面
				map.put("account", username);
				map.put("iserror", check);
				map.put("errormessage", errormessage);
				return new ModelAndView("login", map);
			} catch (Exception e) {
				return getErrorModelAndView(e);// 导向错误页面
			}
	}

	public ModelAndView loginout(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		return new ModelAndView("login");
	}

	public ModelAndView index(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView("index");
	}
}
