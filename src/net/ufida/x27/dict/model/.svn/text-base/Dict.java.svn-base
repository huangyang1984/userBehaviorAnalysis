package net.ufida.x27.dict.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.ufida.x27.exception.X27Exception;
import net.ufida.x27.util.hibernate.BaseModel;
import net.ufida.x27.util.hibernate.ModelUtils;

/**
 * @hibernate.class table="TB_COMMON_DICT" dynamic-insert="true" dynamic-update="true"
 */
public class Dict extends BaseModel {
    
    /**@hibernate.id column="dict_id" generator-class="uuid" length="32" type="string"
     */
    private String idStr;
    
    /**@hibernate.property column="code" length="4" type="string" not-null="true" unique="true"
     */
    private String code;
    
    /**@hibernate.property column="name" length="60" type="string" not-null="true" unique="true"
     */
    private String name;
    
    /**@hibernate.property column="memo" length="200" type="string" not-null="true"
     */
    private String memo;

    
    /**@hibernate.bag cascade="all-delete-orphan" lazy="true" inverse="true" order-by="code"
     * @hibernate.key column="dict_id"
     * @hibernate.one-to-many class="net.gbicc.x27.dict.model.Enums"
     */
    private List enumList;
    
    public Dict() {
    }
    
    public Dict(String idStr) {
        this.idStr = idStr;
    }
    
    public Dict(String code, String name, String memo) {
        this.code = code;
        this.name = name;
        this.memo = memo;
    }
    
    public void initEnumList() {
        if (enumList == null) {
            enumList = new LinkedList();
        }
    }
    
    public void updateNewDictCode() {
        if (enumList == null) {
            return;
        }
        for (Iterator iter = enumList.iterator(); iter.hasNext();) {
            Enums element = (Enums) iter.next();
            element.setCode(code + element.getCode().substring(4, 9));
        }
    }
    
    public void checkEnumList() {
        if (enumList == null) {
            return;
        }
        Set codeSet = new HashSet(enumList.size());
        Set valueSet = new HashSet(enumList.size());
        for (Iterator iter = enumList.iterator(); iter.hasNext();) {
            Enums element = (Enums) iter.next();
            /*在同一个数据字典下，enum.code不能重复*/
            if (!codeSet.add(element.getCode())) {
                throw new IllegalArgumentException("code repetition:" + element.getCode());
            }
            /*在同一个数据字典下，value不能重复*/
            if (!valueSet.add(element.getValue())) {
                throw new IllegalArgumentException("value repetition:" + element.getValue());
            }
            /*每个枚举的code的前4位必须和数据字典的code相同*/
            if (!element.getCode().substring(0, 4).equals(code)) {
                throw new IllegalArgumentException("invalid enum code:" + element.getCode() + ",dict.code:" + code);
            }
        }
    }
    
    public void addEnum(Enums param) {
        initEnumList();
        param.setDict(this);
        for (Iterator iter = enumList.iterator(); iter.hasNext();) {
            Enums element = (Enums) iter.next();
            if (param.getCode().equals(element.getCode())) {
                throw X27Exception.enum_code_exist();
            }
            if (param.getValue().equals(element.getValue())) {
                throw X27Exception.enum_value_exist();
            }
        }
        enumList.add(param);
    }
    
    public void updateEnum(Enums param) {
        initEnumList();
        param.setDict(this);
        Enums enumUpdate = null;
        for (Iterator iter = enumList.iterator(); iter.hasNext();) {
            Enums element = (Enums) iter.next();
            if (element.getIdStr().equals(param.getIdStr())) {
                enumUpdate = element;
                continue;
            }
            if (param.getCode().equals(element.getCode())) {
                throw X27Exception.enum_code_exist();
            }
            if (param.getValue().equals(element.getValue())) {
                throw X27Exception.enum_value_exist();
            }
        }
        if (enumUpdate == null) {
            throw new IllegalArgumentException("enum not exits:" + param);
        }
        ModelUtils.transferValue(param, enumUpdate);
    }
    
    public Enums getEnumByIndex(int index) {
        return (Enums) enumList.get(index);
    }
    
    public Enums getEnumByCode(String code) {
        if (enumList == null) {
            return null;
        }
        for (Iterator iter = enumList.iterator(); iter.hasNext();) {
            Enums element = (Enums) iter.next();
            if (element.getCode().equals(code)) {
                return element;
            }
        }
        return null;
    }
    
    public void remove(String enumId) {
        if (enumList == null) {
            return;
        }
        for (Iterator iter = enumList.iterator(); iter.hasNext();) {
            Enums element = (Enums) iter.next();
            if (element.getIdStr().equals(enumId)) {
                iter.remove();
            }
        }
    }
    
    public List getEnumList() {
        return enumList;
    }
    public void setEnumList(List enumList) {
        this.enumList = enumList;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }
    
}
