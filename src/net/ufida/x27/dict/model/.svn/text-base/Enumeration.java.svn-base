package net.ufida.x27.dict.model;

import net.ufida.x27.util.hibernate.BaseObject;

/**
 * 
 * @author Steven.yang
 *
 */
public class Enumeration extends BaseObject {

    private static final long serialVersionUID = 5101107364422384991L;

    /**
     * 字典或元素代码
     */
    private String code;

    /**
     * 字典或元素名称
     */
    private String name;

    public Enumeration() {
    }

    public Enumeration(String code) {
        this(code, null);
    }

    /**
     * @param code
     * @param name
     */
    public Enumeration(String code, String name) {
        this.name = name;
        this.code = code;
    }

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

    public int hashCode() {
        return code == null ? super.hashCode() : code.hashCode();
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        /* 因为字节码增强的关系，getClass()不能用作判断的依据 */
        if (getClass().getPackage() != other.getClass().getPackage()) {
            return false;
        }
        if (hashCode() == other.hashCode()) {
            return true;
        }
        return false;
    }

}
