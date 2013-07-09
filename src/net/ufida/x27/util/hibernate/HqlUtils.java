package net.ufida.x27.util.hibernate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class HqlUtils {
    
    private static final Logger log = Logger.getLogger(HqlUtils.class);

    /**
     * 去除hql的select 子句
     * @param hql
     * @return hql
     */
    public static String removeSelect(String hql) {
        Assert.hasText(hql);
        int beginPos = hql.toLowerCase().indexOf("from");
        Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'");
        return hql.substring(beginPos);
    }

    /**
     * 去除hql的orderby 子句
     * @param hql
     * @return hql
     */
    public static String removeOrders(String hql) {
        Assert.hasText(hql);
        Pattern pattern = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hql);
        StringBuffer buf = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buf, "");
        }
        matcher.appendTail(buf);
        return buf.toString();
    }
}
