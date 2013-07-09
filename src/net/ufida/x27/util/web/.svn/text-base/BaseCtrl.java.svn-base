package net.ufida.x27.util.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.NoSuchMessageException;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * ctrl基类，也可以直接继承MultiActionController 提供JSONConvert对象
 * 
 */
public class BaseCtrl extends MultiActionController {
	

	public static int pageSize2 = 2;
    public static int pageSize15 = 15;
    public static int pageSize20 = 20;
    public static int pageSize30 = 30;
    
	/** 日志对象 */
	protected final Logger log = Logger.getLogger(getClass());
	
	private final static TokenProcessorUtils tokenProcessorUtils = TokenProcessorUtils.getInstance();

	protected BindException bindObject(HttpServletRequest request,
			Object command, Validator validator) throws Exception {
		ServletRequestDataBinder binder = createBinder(request, command);
		binder.bind(request);
		BindException errors = new BindException(command,
				getCommandName(command));
		if (validator.supports(command.getClass())) {
			ValidationUtils.invokeValidator(validator, command, errors);
		}
		return errors;
	}
	
	protected BindException validator(
			Object command, Validator validator) throws Exception {
		BindException errors = new BindException(command,
				getCommandName(command));
		if (validator.supports(command.getClass())) {
			ValidationUtils.invokeValidator(validator, command, errors);
		}
		return errors;
	}
	
	protected boolean tokenIsValid(HttpServletRequest request) {
		return tokenProcessorUtils.tokenIsValid(request);
	}

	protected ModelAndView getErrorModelAndView(Exception e) {
		Map map = new HashMap();
		
		String errMsg = "";
		map.put("errMsg", e.getMessage());
		return CtrlUtils.getModelAndView("", "error", map);
	}

	/**
	 * 获得属性properties里配置的信息
	 */
	public String getMessage(String msgKey) throws NoSuchMessageException {
		return this.getMessageSourceAccessor().getMessage(msgKey);
	}

	protected JSONConvert jsonConvert;

	public void setJsonConvert(JSONConvert jsonConvert) {
		this.jsonConvert = jsonConvert;
	}

}
