package net.ufida.x27.util.web;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

import net.sf.json.util.JSONUtils;
import net.ufida.x27.dict.model.Dictionary;
import net.ufida.x27.dict.model.Enumeration;

/**
 * 
 * @author Steven.yang
 *
 */
public class JSONUtil {
    
    /**构造JSON数组
     * @param key
     * @param value
     * @return
     */
    public static String assembleArrayEnum(String key, String value) {
        return '[' + JSONUtils.quote(key) + ',' + JSONUtils.quote(value) + ']';
    }
    
    /**构造JSON数组
     * @param enumeration
     * @param needTwoArray 是否需要二维数组
     * @return
     */
    public static String assembleArrayEnum(Enumeration enumeration, boolean needTwoArray) {
        if (needTwoArray) {
            return assembleArrayEnum(enumeration.getCode(), enumeration.getName());
        } else {
            return JSONUtils.quote(enumeration.getName());
        }
    }
    
    /**构造JSON二维数组
     * @param dictionary
     * @param needTwoArray 是否需要二维数组
     * @return
     */
    public static String assembleArrayArray(Dictionary dictionary, boolean needTwoArray) {
        StringBuffer buf = new StringBuffer(20);
        for (Iterator iter = dictionary.getEnumMap().values().iterator(); iter.hasNext();) {
            buf.append(',' + assembleArrayEnum((Enumeration) iter.next(), needTwoArray));
        }
        //删除第一个逗号
        if (buf.length() != 0) {
            buf.deleteCharAt(0);
        }
        return '[' + buf.toString() + ']';
    }
    
    /**构造适合页面用的三维大数组
     * 大数组例：
     * [[["1001","类别1"],[["2010","scama"],["2020","中文项目"]]],
     *  [["1002","类别2"],[["3010","权证"],["3020","smg"]]]
     * ]
     * @param collect Dictionary列表
     * @return
     */
    public static String assembleArray2Level(Collection collect) {
        StringBuffer buf = new StringBuffer(100);
        for (Iterator iterator = collect.iterator(); iterator.hasNext();) {
            Dictionary dictionary = (Dictionary) iterator.next();
            buf.append(",[" + assembleArrayEnum(dictionary.getCode(), dictionary.getName())
                     + ',' + assembleArrayArray(dictionary, true) + ']');
        }
        //删除第一个逗号
        if (buf.length() != 0) {
            buf.deleteCharAt(0);
        }
        return '[' + buf.toString() + ']';
    }
    
    /**
     * 把1级Dictionary中的枚举转换成2级数据字典列表，2级联动数据需要
     * @param dictionary
     * @return LinkedHashMap<dictCode, Dictionary>
     */
    public static LinkedHashMap convert(Dictionary dictionary) {
        Collection collect = dictionary.getEnumMap().values();
        LinkedHashMap map = new LinkedHashMap(collect.size());
        for (Iterator iterator = collect.iterator(); iterator.hasNext();) {
            Enumeration enumeration = (Enumeration) iterator.next();
            Dictionary dictionaryTemp = new Dictionary(enumeration.getCode(), enumeration.getName());
            map.put(dictionaryTemp.getCode(), dictionaryTemp);
        }
        return map;
    }
    
}
