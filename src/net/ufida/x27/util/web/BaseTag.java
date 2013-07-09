package net.ufida.x27.util.web;

import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**ctrl基类，也可以直接继承TagSupport
 * 体供WebApplicationContext对象
 */
public abstract class BaseTag extends TagSupport {
    /**日志对象*/
    protected final Logger log = Logger.getLogger(getClass());
    
    private static WebApplicationContext webApplicationContext;
    
    protected WebApplicationContext getWebApplicationContext() {
        if (webApplicationContext == null) {
            webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(super.pageContext.getServletContext());
        }
        return webApplicationContext;
    }
}
