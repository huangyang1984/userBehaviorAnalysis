package net.ufida.info.web.tag;

import net.ufida.x27.util.web.BaseTag;
import net.ufida.x27.util.web.TagUtils;

import org.apache.commons.lang.StringUtils;

/**
 * 类型列表标签
 *
 */
public class TypeSelectTag extends BaseTag {
	//用于返回select标签的id
	private String id;
	
	//用于返回select标签的name
	private String name;
	
	//option的所有的值，逗号分隔
	private String optionValues;
	
	//option的所有的值对应的名称，逗号分隔
	private String optionTexts;
	
	//宽
	private int width = -1;
	
	//默认名称
	private String defaultOptionName = "";
	
	//默认值
	private String defaultOptionValue = "";
	
	//css类
	private String classStyle;
	
	public int doStartTag() {
        return super.EVAL_BODY_INCLUDE;
    }
    
    public int doEndTag() {
    	String[] value = optionValues.split(",");
    	String[] text = optionTexts.split(",");
    	//组织select标签
    	StringBuilder sb = new StringBuilder();
    	sb.append("<select id=\"").append(id).append("\" name=\"").append(name).append("\" ").append("class=\"").append(classStyle).append("\" ");
    	if (width > 0) {
    		sb.append("style=\"width:").append(width).append(">");
    	} else {
    		sb.append(">");
    	}
    	//组织option标签
    	for(int i = 0; i < value.length; i++){
    		sb.append("<option value=\"").append(value[i]).append(" \" ");
    		//默认值如果存在，且和类型相同，则选中
			if (StringUtils.isEmpty(defaultOptionValue) == false && defaultOptionValue.equals(value[i])) {
				sb.append(" selected >");
			} else {
				sb.append(" >");
			}
			sb.append(text[i]).append("</option>");
    	}
    	sb.append("</select>");
    	
        TagUtils.pageContextWrite(pageContext, sb.toString());
        return super.EVAL_PAGE;
    }

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOptionValues(String optionValues) {
		this.optionValues = optionValues;
	}

	public void setOptionTexts(String optionTexts) {
		this.optionTexts = optionTexts;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public void setDefaultOptionName(String defaultOptionName) {
		this.defaultOptionName = defaultOptionName;
	}

	public void setDefaultOptionValue(String defaultOptionValue) {
		this.defaultOptionValue = defaultOptionValue;
	}

	public void setClassStyle(String classStyle) {
		this.classStyle = classStyle;
	}
}
