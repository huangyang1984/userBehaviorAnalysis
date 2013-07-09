package net.ufida.x27.util.web;

import java.util.LinkedList;
import java.util.List;

import net.ufida.x27.util.hibernate.BaseObject;

/**
 * 
 * @author Steven.yang
 *
 */
public class Page extends BaseObject {
    
    private int totalProperty;
    
    private List items;
    
    private PageParam pageParam;
    
    public Page getDefault() {
        return new Page(0, new LinkedList());
    }

    public Page(int totalProperty, List datas) {
        this.totalProperty = totalProperty;
        this.items = datas;
    }

    public int getTotalProperty() {
        return totalProperty;
    }

    public void setTotalProperty(int totalProperty) {
        this.totalProperty = totalProperty;
    }

    public List getItems() {
        return items;
    }

    public void setDatas(List datas) {
        this.items = datas;
    }

	public PageParam getPageParam() {
		return pageParam;
	}

	public void setPageParam(PageParam pageParam) {
		this.pageParam = pageParam;
	}
    
    
}
