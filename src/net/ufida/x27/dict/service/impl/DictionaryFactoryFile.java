package net.ufida.x27.dict.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.ufida.x27.dict.service.DictionaryFactory;

public class DictionaryFactoryFile extends DictionaryFactory {

    private static final long serialVersionUID = 5481249966826411476L;

    protected List getData(String dictCode) {
        // dictCode无用
        Map fileInfoMap = super.config.getMap();
        List list = new LinkedList();
        for (Iterator iterator = fileInfoMap.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            if (!super.isValidEnumCode(key)) {
                continue;
            }
            String dictKey = super.getDictCodeFromEnumCode(key);
            Map elementMap = new HashMap(4);
            elementMap.put(super.DICT_CODE, dictKey);
            elementMap.put(super.DICT_NAME, fileInfoMap.get(dictKey));
            elementMap.put(super.ENUM_CODE, key);
            elementMap.put(super.ENUM_NAME, entry.getValue());
            log.info("==============================" + elementMap);///////////////////
            list.add(elementMap);
        }
        return list;
    }

}
