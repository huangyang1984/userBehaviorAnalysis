package net.ufida.x27.dict.service;

import java.util.Collection;
import java.util.List;

import net.ufida.x27.dict.model.Dict;
import net.ufida.x27.dict.model.Enums;

public interface DictService {

    /**
     * 页面查询专用
     * @param code 精确匹配
     * @param name 模糊匹配
     * @return List<Dict>
     */
    public List findList(String code, String name);

    public Dict findById(String id);

    public Dict findByCode(String code);
    
    public Dict findByName(String name);

    public void deleteDictById(String id);

    public void saveEnum(Enums param, String dictId);
    
    public void updateEnum(Enums param);
    
    public void deleteEnumById(String id);
    
    public void save(Dict param);
    public void deleteByIds(Collection ids);

    public void updateByParam(Dict param);
    
    public List findList(Dict example, boolean isLike);
    
    public String getDictNameFromCache(String dictCode);

}
