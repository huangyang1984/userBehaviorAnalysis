package net.ufida.x27.exception;

public class X27Exception extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1444767325326451170L;

    public final static String PRIVILNAME_HAS_EXIST = "权限名称已经被另一个权限所使用";
    
    public final static String ROLENAME_HAS_EXIST = "相同的角色名称已经存在";

    public final static String DICT_NAME_EXIST = "字典名称已经存在";

    public final static String DICT_CODE_EXIST = "字典编码已经存在";

    public final static String ENUM_VALUE_EXIST = "当前数据字典中枚举的值已经存在";

    public final static String ENUM_CODE_EXIST = "当前数据字典中枚举的编码已经存在";
    
    public static final String UPLOAD_REPOER_FileTooBig = "上传的文件太大。";

    public X27Exception(String msg) {
        super(msg);
    }

    public static X27Exception dict_code_exist() {
        return new X27Exception(DICT_CODE_EXIST);
    }

    public static X27Exception dict_name_exist() {
        return new X27Exception(DICT_NAME_EXIST);
    }

    public static X27Exception enum_value_exist() {
        return new X27Exception(ENUM_VALUE_EXIST);
    }

    public static X27Exception enum_code_exist() {
        return new X27Exception(ENUM_CODE_EXIST);
    }

    public static X27Exception role_name_has_exist() {
        return new X27Exception(ROLENAME_HAS_EXIST);
    }
    
    public static X27Exception privil_name_has_exist() {
        return new X27Exception(PRIVILNAME_HAS_EXIST);
    }
}
