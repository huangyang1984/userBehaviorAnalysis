package net.ufida.x27.util.text;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;

public class DateTimeUtils {
    public static final Logger log = Logger.getLogger(DateTimeUtils.class);

    public final static String FORMAT_yyyy_MM_dd = "yyyy-MM-dd";

    public final static String FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    
    public final static String FORMAT_yyyy_nian_MM_yue_mm_ri = "yyyy年MM月dd日";
    
    public final static String FORMAT_yyyy_nian_M_yue_m_ri = "yyyy年M月d日";
    
    private final static char[][] CHINESE_CHAR = {
        {'0', '〇'},
        {'1', '一'},
        {'2', '二'},
        {'3', '三'},
        {'4', '四'},
        {'5', '五'},
        {'6', '六'},
        {'7', '七'},
        {'8', '八'},
        {'9', '九'}
    };
    
//    public static void main(String[] args) {
//        System.out.println(convertChar2ChineseChar(now2Str(FORMAT_yyyy_nian_M_yue_m_ri)));
//    }
    
    public static int nowYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    
    public static int nowMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }
    
    public static int nowDayOfMonth() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }
    
    public static String convertChar2ChineseChar(String dateTimeStr) {
        if (StringUtils.isEmpty(dateTimeStr)) {
            return "";
        }
        StringBuffer buf = new StringBuffer(dateTimeStr.length());
        for (int i = 0; i < dateTimeStr.length(); i++) {
            buf.append(convertChar2ChineseChar(dateTimeStr.charAt(i)));
        }
        return buf.toString();
    }
    
    public static char convertChar2ChineseChar(char dateTimeChar) {
        for (int i = 0; i < CHINESE_CHAR.length; i++) {
            if (CHINESE_CHAR[i][0] == dateTimeChar) {
                return CHINESE_CHAR[i][1];
            }
        }
        return dateTimeChar;
    }

    /**
     * Date转换到Calendar
     * @param date 要转换的Date
     * @return Calendar
     */
    public static Calendar date2Calendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 设置指定的Calendar“时、分、妙”为零
     * @param calendar Calendar
     */
    public static void setTimeZero(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
    }

    /**
     * 得到当前时间的字符串yyyy-MM-dd
     * @return String
     */
    public static String now2StrDate() {
        return now2Str(FORMAT_yyyy_MM_dd);
    }

    /**
     * 得到当前时间的字符串yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String now2StrDateTime() {
        return now2Str(FORMAT_yyyy_MM_dd_HH_mm_ss);
    }

    /**
     * 得到当前时间的字符串
     * @param format 字符串格式
     * @return String
     * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date, String)
     */
    public static String now2Str(String format) {
        return DateFormatUtils.format(new Date(), format);
    }

    /**
     * Date转换到字符串yyyy-MM-dd
     * @param date Date
     * @return String yyyy-MM-dd
     * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date, String)
     */
    public static String date2StrDate(Date date) {
        return DateFormatUtils.format(date, FORMAT_yyyy_MM_dd);
    }
    
    /**
     * Date转换到字符串
     * @param date
     * @param format
     * @return
     */
    public static String date2StrDate(Date date, String format) {
        return DateFormatUtils.format(date, format);
    }

    /**
     * Date转换到字符串yyyy-MM-dd HH:mm:ss
     * @param date Date
     * @return String yyyy-MM-dd HH:mm:ss
     * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date, String)
     */
    public static String date2StrDateTime(Date date) {
        return DateFormatUtils.format(date, FORMAT_yyyy_MM_dd_HH_mm_ss);
    }

    /**
     * Calendar转换到字符串yyyy-MM-dd
     * @param calendar Calendar
     * @return String yyyy-MM-dd
     * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date, String)
     */
    public static String calendar2StrDate(Calendar calendar) {
        return date2StrDate(calendar.getTime());
    }

    /**
     * Calendar转换到字符串yyyy-MM-dd HH:mm:ss
     * @param calendar Calendar
     * @return String yyyy-MM-dd HH:mm:ss
     * @see org.apache.commons.lang.time.DateFormatUtils.DateFormatUtils#format(Date, String)
     */
    public static String calendar2StrDateTime(Calendar calendar) {
    	if(calendar==null)return "";
        return date2StrDateTime(calendar.getTime());
    }

    /**
     * 字符串yyyy-MM-dd转换到Calendar类型
     * @param dateStr yyyy-MM-dd
     * @return Calendar
     */
    public static Calendar strDate2Calendar(String dateStr) {
        return str2Calendar(dateStr, FORMAT_yyyy_MM_dd);
    }

    /**
     * 字符串yyyy-MM-dd转换到Date类型
     * @param dateStr yyyy-MM-dd
     * @return Date
     */
    public static Date strDate2Date(String dateStr) {
        return str2Date(dateStr, FORMAT_yyyy_MM_dd);
    }

    /**
     * 字符串yyyy-MM-dd HH:mm:ss转换到Calendar类型
     * @param dateStr yyyy-MM-dd HH:mm:ss
     * @return Calendar
     */
    public static Calendar strDateTime2Calendar(String dateStr) {
        return str2Calendar(dateStr, FORMAT_yyyy_MM_dd_HH_mm_ss);
    }

    /**
     * 字符串yyyy-MM-dd HH:mm:ss转换到Date类型
     * @param dateStr yyyy-MM-dd HH:mm:ss
     * @return Date
     */
    public static Date strDateTime2Date(String dateStr) {
        return str2Date(dateStr, FORMAT_yyyy_MM_dd_HH_mm_ss);
    }

    /**
     * 字符串转换到Date类型
     * @param dateStr 需要转换的字符串
     * @param format 转换格式
     * @return Date
     */
    public static Date str2Date(String dateStr, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        Date date = dateFormat.parse(dateStr, new ParsePosition(0));
        return date;
    }

    /**
     * 字符串转换到Calendar类型
     * @param dateStr 需要转换的字符串
     * @param format 转换格式
     * @return Calendar
     */
    public static Calendar str2Calendar(String dateStr, String format) {
        Calendar calendar = Calendar.getInstance();
//        log.info(calendar);
        calendar.setTime(str2Date(dateStr, format));
//        log.info(calendar);
        return calendar;
    }
    
    /** 
     *  得到当前日期的Calendar类型
     * @return Calendar;
     */
    public static Calendar now2Calendar() {
        return Calendar.getInstance();
    }
    
    /**
     * 得到当前日期的FORMAT_yyyy_nian_M_yue_m_ri类型 
     */
    public static String calendar2DateStr(Calendar calendar ) {    	
    	String str = calendar2StrDate(calendar);
		Date date = str2Date(str, DateTimeUtils.FORMAT_yyyy_MM_dd);
		String dateStr = date2StrDate(date,DateTimeUtils.FORMAT_yyyy_nian_M_yue_m_ri);
		
        return dateStr;
    }
    
    /**
     * 字符串yyyy-MM-dd HH:mm:ss 转换到 当天的开始Calendar类型 
     * @param dateStr yyyy-MM-dd HH:mm:ss
     * @return Calendar
     */
    public static Calendar strDateTime2CalendarDayBegin(String dateStr) {
        return str2Calendar(dateStr.substring(0, 10) +" 00:00:00", FORMAT_yyyy_MM_dd_HH_mm_ss);
    }
    
    /**
     * 字符串yyyy-MM-dd HH:mm:ss 转换到 当天的结束Calendar类型 
     * @param dateStr yyyy-MM-dd HH:mm:ss
     * @return Calendar
     */
    public static Calendar strDateTime2CalendarDayEnd(String dateStr) {
        return str2Calendar(dateStr.substring(0, 10) +" 23:59:59", FORMAT_yyyy_MM_dd_HH_mm_ss);
    }
    
    public static void main(String args[]) {
//        System.out.println(DateTimeUtils.calendar2StrDateTime(Calendar.getInstance()));
//        for (int i = 0; i <100; i++) {
//            System.out.println(DateTimeUtils.getCurNoFormatDateTime());
//        }
        
//        Calendar calendar = DateTimeUtils.strDateTime2Calendar("2008-10-01 13:26:35");
//        System.out.println(DateTimeUtils.calendar2StrDateTime(calendar));
        
//        System.out.println(DateTimeUtils.calendar2StrDateTime(calendar));
    }
}
