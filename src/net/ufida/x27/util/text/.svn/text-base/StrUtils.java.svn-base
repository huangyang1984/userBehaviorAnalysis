package net.ufida.x27.util.text;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class StrUtils {
    public static final Logger log = Logger.getLogger(StrUtils.class);

    /** "," */
    private static final String DIVIDER = ",";

    /**
     * 根据指定数字，返回此数字的文本，根据需要的长度，在返回的文本前加零 example:addZeroBefore(34, 4);返回"0034"
     * @param num
     * @param needLength
     * @return
     */
    public static String addZeroBefore(int num, int needLength) {
        return addZeroBefore("" + num, needLength);
    }

    public static String addZeroBefore(String str, int needLength) {
        StringBuffer buf = new StringBuffer(str);
        while (buf.length() < needLength) {
            buf.insert(0, "0");
        }
        return buf.toString();
    }

    /**
     * 按照分隔符“,”把字符串转换到列表
     * @param str 要转换的字符串
     * @return List
     */
    public static List str2List(String str) {
        return str2List(str, DIVIDER);
    }

    /**
     * 按照制定分隔符把字符串转换到列表
     * @param str 要转换的字符串
     * @param token 分隔符
     * @return List
     */
    public static List str2List(String str, String token) {
        return Arrays.asList(str.split(token));
    }

    /**
     * 按照分隔符“,”把列表转换到字符串
     * @param collect 要转换的列表
     * @return String
     */
    public static String list2Str(Collection collect) {
        return list2Str(collect, DIVIDER);
    }

    /**
     * 按照制定分隔符把列表转换到字符串
     * @param collect 要转换的列表
     * @param token 分隔符
     * @return String
     */
    public static String list2Str(Collection collect, String token) {
        if (StringUtils.isEmpty(token)) {
            throw new IllegalArgumentException("invalid token:" + token);
        }
        StringBuffer buf = new StringBuffer(collect.size() * 5);
        for (Iterator iterator = collect.iterator(); iterator.hasNext();) {
            buf.append(token + iterator.next());
        }
        return buf.delete(0, token.length()).toString();
    }

    /**
     * 描述：字符串转换成数据。 比如：tradeCodeS=" 31 01,3121 , 31 31, 3412, " 转换成数组 {"3101","3121","3131","3412"}
     * @param tradeCodeS
     * @return String[]
     */
    public static String[] StringToArray(String tradeCodeS) {
        return tradeCodeS.replaceAll("\\s*", "").split("[,]");
    }

    /**
     * 生成具有业务意义的预警流水号
     * 注意该方法未设成线程安全的
     * @return
     */
    public static String genAlarmNo() {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyyMMddHHmmss");
        String prevStr = format.format(Calendar.getInstance().getTime()).toString();
        
        
        String nextStr = addZeroBefore(0, 4);

        return prevStr + nextStr;
    }
    
    public static String converCountToCountByPercent(String countStr) {
        if (StringUtils.isNotEmpty(countStr) == true) {
            float floatValue = (Float.parseFloat(countStr)) * 100;
            return String.valueOf(Math.round(floatValue)) + "%";
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyyMMddHHmmss");
        String prevStr = format.format(Calendar.getInstance().getTime()).toString();
        System.out.println(prevStr);
    }
}
