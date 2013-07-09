package net.ufida.x27.util.web;

import java.io.IOException;

import javax.servlet.jsp.PageContext;

import org.springframework.util.ReflectionUtils;

/**
 * 
 * @author Steven.yang
 *
 */
public class TagUtils {
    public static void pageContextWrite(PageContext pageContext, String str) {
        try {
            pageContext.getOut().write(str);
        } catch (IOException ex) {
            ReflectionUtils.handleReflectionException(ex);
        }
    }
}
