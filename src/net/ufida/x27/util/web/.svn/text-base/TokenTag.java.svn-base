package net.ufida.x27.util.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TokenTag extends TagSupport {
private Log log = LogFactory.getLog(this.getClass());
    
    public int doEndTag() throws JspException {
        TokenProcessorUtils tokenProcessorUtils = TokenProcessorUtils.getInstance();
        HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();
        String token = tokenProcessorUtils.getToken(request);
        
        StringBuilder sb = new StringBuilder();
        sb.append("<input type=\"hidden\" name=\"");
        sb.append(tokenProcessorUtils.TOKEN_KEY);
        sb.append("\" value=\"");
        sb.append(token);
        sb.append("\" />");
        
        log.debug("TokenTag's token value:"+token);
        
        JspWriter out = this.pageContext.getOut();
        try {
            out.write(sb.toString());
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        
        return EVAL_PAGE;
    }
    
    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }
}
