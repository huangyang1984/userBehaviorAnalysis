package net.ufida.x27.dict.service;

import java.util.Collection;
import java.util.List;

import net.ufida.x27.dict.model.Enums;

public interface EnumService {

    public List findList(Enums example);

    public Enums findByCode(String code);
    
    public Enums findById(String id);
    
    public Enums findByIdAllowNull(String id);
    
    public String findValueByCode(String code);
    
    public void deleteByIdList(Collection ids);
    
    String getEnumNameFromCache(String dictCode, String enumCode);
}
