package net.ufida.x27.util.hibernate;

import java.io.Serializable;

import net.ufida.x27.util.web.JSONNotAware;


public interface Modelable extends JSONNotAware, Serializable, Cloneable {
    /**
     * model中的属性强烈推荐名称定为idStr，在JSONConvertUtils中做转换的时候，
     * 多对一的那一方可以不触发sql语句，直接通过这个方法拿到id
     * @return
     */
    String getIdStr();
    
    void setIdStr(String idStr);
    
}
