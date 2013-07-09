package net.ufida.x27.dict.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ufida.x27.dict.model.Dictionary;
import net.ufida.x27.dict.model.Enumeration;
import net.ufida.x27.dict.service.impl.DictionaryFactoryFile;
import net.ufida.x27.util.cfg.ConfigFile;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;

public abstract class DictionaryFactory implements Serializable {
    
    private static final long serialVersionUID = 6417761806628943394L;

    protected final Logger log = Logger.getLogger(getClass());
    
    private static final String DICT_APPLICATION_PERIOD = "DICTApplication.period";

    public static final String DICT_CODE = "dictCode";
    
    public static final String DICT_NAME = "dictName";

    public static final String ENUM_CODE = "enumCode";

    public static final String ENUM_NAME = "enumName";
    
    private GeneralCacheAdministrator cache = new GeneralCacheAdministrator();
    
    protected ConfigFile config;

    /**得到所有的枚举数据，每个枚举的map中包含四个元素
     * ，DictionaryFactory.DICT_CODE
     * ，DictionaryFactory.DICT_NAME
     * ，DictionaryFactory.ENUM_CODE
     * ，DictionaryFactory.ENUM_NAME
     * @return List<Map<key, value>>
     */
    protected abstract List getData(String dictCode);

    public Enumeration getEnumByName(String dictName, String enumName) {
        Assert.hasText(dictName, "dictName is null");
        Assert.hasText(dictName, "dictName is null");
        Assert.isInstanceOf(DictionaryFactoryFile.class, this, "this class must be DictionaryFactoryFile");
        Enumeration enumeration = new Enumeration(null, enumName);
        for (Iterator iterator = getData(null).iterator(); iterator.hasNext();) {
            Map map = (Map) iterator.next();
            if (dictName.equals(map.get(DICT_NAME)) && enumName.equals(map.get(ENUM_NAME))) {
                enumeration = new Enumeration(map.get(ENUM_CODE).toString(), enumName);
            }
        }
        Assert.notNull(enumeration, "dictName:" + dictName + ",enumName:" + enumName + ",not found");
        return enumeration;
    }
    
    public String getDictionaryName(String dictCode) {
    	Dictionary dictionary = getDictionary(dictCode);
    	if (dictionary == null) {
    		return "";
    	}
    	
    	return dictionary.getName();
    }

    /**
     * 根据字典代码取字典
     * @param code
     * @return
     */
    public Dictionary getDictionary(String dictCode) {
        if (dictCode == null) {
            return null;
        }
        // 先从缓存中查找字典，如果存在就直接返回。
        int period = getPeriod(dictCode);
        //0表示缓存永远有效，负数表示不放入缓存
        if (period == 0) {
            period = Integer.MAX_VALUE;
        }
        if (period > 0) {
            try {
                Dictionary temp = (Dictionary) cache.getFromCache(dictCode, period);
                if (temp != null) {
                    return temp;
                }
            } catch (NeedsRefreshException ex) {
            	ex.printStackTrace();
            }
        }
        
        Map dictMap = assembleDictionary(dictCode);
        // 放入缓存中
        for (Iterator iterator = dictMap.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            cache.putInCache((String) entry.getKey(), entry.getValue());
        }
        
        Dictionary dictionary = (Dictionary) dictMap.get(dictCode);
//        Assert.notNull(dictionary, "invalid dictCode:" + dictCode);
        return dictionary;
    }
    
    /**
     * 如果没有在配置文件中找到字典的缓存时间，那么取全局缓存时间。
     * @param dictCode
     */
    private int getPeriod(String dictCode) {
        String periodStr = config.getString(dictCode + ".period");
        if (StringUtils.isEmpty(periodStr)) {
            //没有在配置文件中找到字典的缓存时间，那么取全局缓存时间。
            //0在ehCache中表示永不过期
            periodStr = StringUtils.defaultIfEmpty(config.getString(DICT_APPLICATION_PERIOD), "0");
        }
        return Integer.parseInt(periodStr);
    }
    
    /**
     * 装配字典
     * @param data
     * @return Map<dictCode,Dictionary>
     */
    private Map assembleDictionary(String dictionaryCode) {
        Map dictMap = new HashMap(1);
        List list = getData(dictionaryCode);
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Map map = (Map) iterator.next();
            String dictCode = map.get(DICT_CODE).toString().trim();
            String dictName = map.get(DICT_NAME).toString().trim();
            String enumCode = map.get(ENUM_CODE).toString().trim();
            String enumName = map.get(ENUM_NAME).toString().trim();
            Enumeration element = new Enumeration(enumCode, enumName);
            Dictionary dict = (Dictionary) dictMap.get(dictCode);
            // 判断在map中有没有dict
            if (dict != null) {
                // 更新字典
                dict.addEnum(enumCode, element);
            } else {
                // 新建字典
                dict = new Dictionary();
                dict.setCode(dictCode);
                dict.setName(dictName);
                dict.addEnum(enumCode, element);
                dictMap.put(dictCode, dict);
            }
        }
        
        return dictMap;
    }


    /**
     * 根据元素代码取元素名称。
     * @param enumCode
     * @return String
     */
    public String getEnumerationName(String enumCode) {
        Enumeration enumeration = getEnumeration(enumCode);
        if (enumeration == null) {
            return "";
        }
        
        return enumeration.getName();
    }
    
    /**业务数据字典专用
     * @param dictCode 业务数据字典名称
     * @param enumCode 编码
     * @return 名称
     */
    public String getEnumerationName(String dictCode, String enumCode) {
        Dictionary dictionary = getDictionary(dictCode);
        if (dictionary == null) {
            return null;
        }
        return dictionary.getEnumName(enumCode);
    }
    
    /**
     * 根据元素中的代码设定元素中的名称
     * @param enumeration
     */
    public void setName(Enumeration enumeration) {
        if (enumeration == null) {
            return;
        }
        Enumeration temp = getEnumeration(enumeration.getCode());
        if (temp == null) {
            return;
        }
        enumeration.setName(temp.getName());
    }
    
    /**
     * 根据元素代码取元素对象。
     * @param enumCode
     * @return Enumeration
     */
    public Enumeration getEnumeration(String enumCode) {
        if (enumCode == null) {
            return null;
        }
        checkEnumCode(enumCode);
        String dictCode = enumCode.substring(0, enumCode.indexOf('-'));
        Dictionary dict = getDictionary(dictCode);
        return null == dict ? null : dict.getEnumeration(enumCode);
    }
    
    
    protected void checkEnumCode(String enumCode) {
        Assert.isTrue(isValidEnumCode(enumCode), "invalid enumCode:" + enumCode);
    }
    
    protected boolean isValidEnumCode(String enumCode) {
        return enumCode.indexOf('-') != -1;
    }

    protected String getDictCodeFromEnumCode(String enumCode) {
        return enumCode.substring(0, enumCode.indexOf('-'));
    }

    public void removeCache(String dictCode) {
        cache.flushEntry(dictCode);
    }

    public void setConfig(ConfigFile config) {
        this.config = config;
    }
    
    public void setCache(GeneralCacheAdministrator cache) {
        this.cache = cache;
    }

}
