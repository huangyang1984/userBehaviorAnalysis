package net.ufida.x27.util.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
  
public class Character4UTF8Filter implements Filter {
    private static final Logger log = Logger.getLogger(Character4UTF8Filter.class);
    
    private String characterEncoding = "UTF-8";
    
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        
        req.setCharacterEncoding(characterEncoding);
        res.setCharacterEncoding(characterEncoding);

        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
    	this.characterEncoding = filterConfig.getInitParameter("encoding");
    }

    public void destroy() {
    }
    
}
