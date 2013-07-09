package net.ufida.x27.util.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.ufida.info.common.listener.SessionListener;

public class SessionTimeOutFilter implements Filter {
    protected ServletContext servletContext = null;

    /**
     * The filter configuration object we are associated with. If this value is null, this filter instance is not
     * currently configured.
     */
    protected FilterConfig filterConfig = null;

    protected String forwardTo = null;

    protected String[] openedURL = null;

    /**
     * Place this filter into service.
     * @param filterConfig The filter configuration object
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.forwardTo = filterConfig.getInitParameter("forwardTo");
        
        if (filterConfig.getInitParameter("openedURL") != null
                && filterConfig.getInitParameter("openedURL").length() > 0)
            this.openedURL = filterConfig.getInitParameter("openedURL").split(",");

        this.servletContext = filterConfig.getServletContext();
    }

    /**
     * Select and set (if specified) the character encoding to be used to interpret request parameters for this request.
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);

        String servletPath = httpServletRequest.getServletPath().toLowerCase().trim();

            if (httpServletRequest.getSession().getAttribute(SessionListener.LISTENER_NAME) == null) {
                if (this.openedURL != null && this.openedURL.length > 0) {
                    boolean needLogin = true;
                    for (int i = 0; i < this.openedURL.length; i++) {
                    	System.out.println("servletPath:"+servletPath);
                    	System.out.println("this.openedURL[i].toLowerCase().trim():"+this.openedURL[i].toLowerCase().trim());
                        if (servletPath.endsWith(this.openedURL[i].toLowerCase().trim()) || servletPath.endsWith("qa.jsp")) {//add by clj 暂时先把知识问答详细页面放在后台处理
                            needLogin = false;
                            break;
                        }
                    }
                    if (needLogin) {
                        servletContext.getRequestDispatcher(this.forwardTo).forward(httpServletRequest, response);
                        return;
                    }
                } else {
                    httpServletRequest.getRequestDispatcher(this.forwardTo).forward(httpServletRequest, response);
                    return;
                }
            }

        chain.doFilter(request, response);
    }

    /**
     * Take this filter out of service.
     */
    public void destroy() {

    }
}
