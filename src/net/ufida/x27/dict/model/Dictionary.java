/**
 * 抽象字典元素
 */
package net.ufida.x27.dict.model;

import java.util.LinkedHashMap;

import net.ufida.x27.util.hibernate.BaseObject;

/**
 * @version 1.0
 */
public class Dictionary extends BaseObject {

    private static final long serialVersionUID = -4842021909210175218L;

    /** 字典元素代码 */
    private String code;

    /** 字典元素名称 */
    private String name;

    /** 元素容器，LinkedHashMap是为了保证顺序 */
    private LinkedHashMap enumMap = new LinkedHashMap(10);

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dictionary() {
    }

    /**
     * @param code
     * @param name
     */
    public Dictionary(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public String getEnumName(String enumCode) {
        Enumeration enumeration = getEnumeration(enumCode);
        if (enumeration == null) {
            return null;
        }
        return enumeration.getName();
    }

    /**
     * 取字典中的元素。
     * @param key
     * @return Element
     */
    public Enumeration getEnumeration(String key) {
        return (Enumeration) enumMap.get(key);
    }

    /**
     * 设置字典中的元素
     * @param key
     * @param enumeration
     */
    public void addEnum(String key, Enumeration enumeration) {
        enumMap.put(key, enumeration);
    }

    public void addEnum(String enumCode, String enumName) {
        enumMap.put(enumCode, new Enumeration(enumCode, enumName));
    }
    
    public void remove(String enumCode) {
        enumMap.remove(enumCode);
    }

    public LinkedHashMap getEnumMap() {
        return enumMap;
    }

    public void setEnumMap(LinkedHashMap enumMap) {
        this.enumMap = enumMap;
    }

}
