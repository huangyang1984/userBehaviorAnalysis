/**
 * 
 */
package net.ufida.commons.base;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 
 * @author Steven.yang
 *
 */
public class ConfigServlet extends HttpServlet {

    public static ServletConfig config;

    /**
     * Init the servlet
     */
    final public void init(ServletConfig config) throws ServletException
    {
        this.config = config;
        super.init(config);
    }

}
