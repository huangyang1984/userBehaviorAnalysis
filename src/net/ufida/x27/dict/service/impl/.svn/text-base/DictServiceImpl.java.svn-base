package net.ufida.x27.dict.service.impl;

import java.util.Collection;
import java.util.List;

import net.ufida.x27.dict.manager.DictManager;
import net.ufida.x27.dict.manager.EnumManager;
import net.ufida.x27.dict.model.Dict;
import net.ufida.x27.dict.model.Enums;
import net.ufida.x27.dict.service.DictService;
import net.ufida.x27.util.hibernate.ModelUtils;

import org.apache.log4j.Logger;

public class DictServiceImpl implements DictService {

    private static final Logger log = Logger.getLogger(DictServiceImpl.class);
    
    private DictionaryFactoryDB dictionaryFactoryDB;

    private DictManager dictManager;

    private EnumManager enumManager;
    
    public void deleteDictById(String id) {
        dictManager.deleteById(id);
    }

    public void saveEnum(Enums param, String dictId) {
        Dict dict = findById(dictId);
        dict.addEnum(param);
        dictManager.updateByParam(dict);
    }

    public void updateEnum(Enums param) {
        Enums entityEnum = enumManager.findById(param.getIdStr());
        ModelUtils.transferValue(param, entityEnum);
        Dict dict = entityEnum.getDict();
        dict.updateEnum(entityEnum);
        dictManager.update(dict);
    }

    public void deleteEnumById(String id) {
        Enums entityEnum = enumManager.findById(id);
        Dict dict = entityEnum.getDict();
        dict.remove(id);
        dictManager.updateByParam(dict);
    }

    public List findList(String code, String name) {
        return dictManager.findList(code, name);
    }

    public void save(Dict param) {
        dictManager.save(param);
    }

    public void updateByParam(Dict param) {
        dictManager.updateByParam(param);
    }
    
    public List findList(Dict example, boolean isLike) {
        return dictManager.findList(example, isLike);
    }
    
    public Dict findById(String id) {
        return dictManager.findById(id);
    }
    
    public Dict findByCode(String code) {
        return dictManager.findByCode(code);
    }
    
    public Dict findByName(String name) {
        return dictManager.findByName(name);
    }
    
    public void setDictManager(DictManager dictManager) {
        this.dictManager = dictManager;
    }

    public void setEnumManager(EnumManager enumManager) {
        this.enumManager = enumManager;
    }

    public void deleteByIds(Collection ids) {
        dictManager.deleteByIdList(ids);
        
    }
    
    public String getDictNameFromCache(String dictCode) {
    	return dictionaryFactoryDB.getDictionaryName(dictCode);
    }

	public void setDictionaryFactoryDB(DictionaryFactoryDB dictionaryFactoryDB) {
		this.dictionaryFactoryDB = dictionaryFactoryDB;
	}

}
