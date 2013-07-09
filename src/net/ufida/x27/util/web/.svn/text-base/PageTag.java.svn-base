package net.ufida.x27.util.web;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class PageTag extends TagSupport {
	private static WebApplicationContext wac = null;

    private int totalCount;
    
    private int page = 1;

//    private int start;
    
    private int limit;

    private void init() {
        if (wac == null) {
            ServletContext sContext = (ServletContext) this.pageContext.getServletContext();
            wac = WebApplicationContextUtils.getRequiredWebApplicationContext(sContext);
        }
    }

    private String getMessage(String key) {
        try {
            if (wac == null) {
                init();
            }
            return wac.getMessage(key, null, Locale.CHINA);
        } catch (Exception e) {
            e.printStackTrace();
            return key;
        }
    }

    public int doEndTag() throws JspException {
    	int totalPage = totalCount/limit;
    	if (totalPage < (totalCount*limit)) {
    		totalPage = totalPage + 1;
    	}
    	
        StringBuffer sb = new StringBuffer();
        sb.append( "共有" + totalCount+"条数据 ");
        
        if (page == 0) {
        	page = 1;
        }
        
        if (totalCount > 0) {
            sb.append("&nbsp;&nbsp;" + "当前页" + page + "/" + totalPage);
        }
        if (totalPage > 1) {
            sb.append(" &nbsp;&nbsp; <a href=\"javascript:gotopage('1')\" style=\"color:#93A6C1\">" + "首页"
                    + "</a>");
        }
        if (page > 1) {
            sb.append("&nbsp;&nbsp;<a href=\"javascript:gotopage('" + (page - 1) + "')\" style=\"color:#93A6C1\">"
                    + "上一页" + "</a>");
        }
        if (totalPage > page) {
            sb.append("&nbsp;&nbsp;<a href=\"javascript:gotopage('" + (page + 1) + "')\" style=\"color:#93A6C1\">"
                    + "下一页" + "</a>");
        }
        if (totalPage > 1) {
            sb.append("&nbsp;&nbsp;<a href=\"javascript:gotopage('" + totalPage + "')\" style=\"color:#93A6C1\">"
                    + "末页" + "</a>&nbsp;&nbsp;");
        }

        sb.append("<script language=\"javascript\">");
        sb.append("function gotopage(page){");
        sb.append(" query.page.value = page;");
        sb.append(" var limit = query.limit.value;");
        sb.append("	query.start.value=(page-1)*limit;");
        sb.append("	query.submit() ;}</script>");
        
        sb.append("<input type=\"hidden\" id=\"page\" name=\"page\" value=\"1\" />");
        sb.append("<input type=\"hidden\" id=\"start\" name=\"start\" value=\"0\" />");
        sb.append("<input type=\"hidden\" id=\"limit\" name=\"limit\" value=\""+limit+"\" />");

        try {
        	JspWriter out = this.pageContext.getOut();
            out.write(new String(sb));
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }

    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

//	public void setStart(int start) {
//		this.start = start;
//	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setPage(int page) {
		this.page = page;
	}
    
}
