package net.ufida.x27.util.web;

import net.ufida.x27.util.hibernate.BaseObject;

/**
 * 
 * @author Steven.yang
 *
 */
public class PageParam extends BaseObject {
    
    public static final String DIR_ASC = "ASC";
    
    public static final String DIR_DESC = "DESC";
    
    /**查询起始位置*/
    private int start = 0;
    
    /**查询个数*/
    private int limit = 12;
    
    /**排序字段名*/
    private String sort;
    
    private int page = 1;
    
    /**排序顺序*/
    private String dir;
    
    public PageParam() {
    }
    
    /**
     * 提供默认的查询条件对象，start=0，limit=CtrlUtils.NUM_PER_PAGE=20
     * @return PageParam
     */
    public static PageParam getDefault() {
        return new PageParam(0, CtrlUtils.NUM_PER_PAGE, null, DIR_ASC);
    }

    public PageParam(int start, int limit, String sort, String dir) {
        this.start = start;
        this.limit = limit;
        this.sort = sort;
        this.dir = dir;
    }

    public int getEnd() {
        return start + limit;
    }

    public String getDir() {
        return dir == null ? null : dir.toUpperCase();
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
    
}
