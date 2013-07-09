package net.ufida.x27.util.text;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class BigDecimalUtils {
    
    public static final BigDecimal ZERO = new BigDecimal("0");
    
    public static final BigDecimal ONE = new BigDecimal("1");
    
    /**
     * 两数相乘，四舍五入，保留2位小数
     * @param one
     * @param two
     * @return
     */
    public static BigDecimal multiply(BigDecimal one, BigDecimal two) {
        return multiply(one, two, 2);
    }
    
    /**
     * 两数相乘，四舍五入
     * @param one
     * @param two
     * @param scale 保留位数
     * @return
     */
    public static BigDecimal multiply(BigDecimal one, BigDecimal two, int scale) {
        return one.multiply(two).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * 三数相乘，四舍五入，保留2位小数
     * @param one
     * @param two
     * @return
     */
    public static BigDecimal multiply(BigDecimal one, BigDecimal two, BigDecimal three) {
        return one.multiply(two).multiply(three).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    public static BigDecimal divide(BigDecimal numerator, BigDecimal denominator) {
        return divide(numerator, denominator, 2);
    }

    public static BigDecimal divide(BigDecimal numerator, BigDecimal denominator, int scale) {
        return numerator.divide(denominator, scale, BigDecimal.ROUND_HALF_UP);
    }
    
    public static BigDecimal setScale(BigDecimal decimal) {
        return decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    
    public static BigDecimal setScale(int scale, BigDecimal decimal) {
        return decimal.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }
    
    /**解析String为BigDecimal，如果str为空返回0，如果抛出NumberFormatException，返回0
     * @param str 需要解析的数字
     * @return BigDecimal
     */
    public static BigDecimal valueOf(String str) {
        return valueOf(str, ZERO);
    }
    
    /**解析String为BigDecimal，如果str为空返回0，如果抛出NumberFormatException，返回default
     * @param str 需要解析的数字
     * @param defaultValue 
     * @return BigDecimal
     */
    public static BigDecimal valueOf(String str, BigDecimal defaultValue) {
        if (StringUtils.isEmpty(str)) {
           return defaultValue;
        }
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }
    
}
