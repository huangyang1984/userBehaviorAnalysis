package net.ufida.x27.dict.service.impl;

import java.util.Collection;
import java.util.List;

import net.ufida.x27.dict.manager.EnumManager;
import net.ufida.x27.dict.model.Enums;
import net.ufida.x27.dict.service.EnumService;

public class EnumServiceImpl implements EnumService {
	private DictionaryFactoryDB dictionaryFactoryDB;
    
    private EnumManager enumManager;
    
    public List findList(Enums example) {
        return enumManager.findList(example);
    }

    public Enums findByCode(String code) {
        return enumManager.findByCode(code);
    }
    
    public Enums findById(String id) {
        return enumManager.findById(id);
    }

    public Enums findByIdAllowNull(String id) {
        return (Enums) enumManager.findByIdAllowNull(id);
    }
    
    public String findValueByCode(String code) {
        Enums enumeration = findByCode(code);
        if (enumeration != null) {
            return enumeration.getValue();
        }else {
            return "";
        }
        
    }
    
    public String getEnumNameFromCache(String dictCode, String enumCode) {
    	return dictionaryFactoryDB.getEnumerationName(dictCode, enumCode);
    }

    public void setEnumManager(EnumManager enumManager) {
        this.enumManager = enumManager;
    }

    public void deleteByIdList(Collection ids) {
        enumManager.deleteByIdList(ids);
        
    }

	public void setDictionaryFactoryDB(DictionaryFactoryDB dictionaryFactoryDB) {
		this.dictionaryFactoryDB = dictionaryFactoryDB;
	}


}
