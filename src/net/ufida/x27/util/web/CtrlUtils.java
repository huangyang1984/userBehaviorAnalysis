package net.ufida.x27.util.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.ufida.x27.util.text.BigDecimalUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

/**页面类中需要用到的工具方法
 */
public class CtrlUtils {
    private static final Logger log = Logger.getLogger(CtrlUtils.class);
    
    public static final int NUM_PER_PAGE = 12;

    private static final String REQUEST_MESSAGE = "REQUEST_MESSAGE";
    
    private static final String SESSION_USER = "SESSION_USER";
    
    public static ModelAndView getModelAndView(String subPath, String fileName) {
        return getModelAndView(subPath, fileName, null);
    }
    
    /**取得必需的参数，如果req中参数不存在抛异常，
     * @param req HttpServletRequest
     * @param name 参数名
     * @see javax.servlet.http.HttpServletRequest#getParameter(String)
     * @return String
     */
    public static String getRequiredStringParameter(HttpServletRequest req, String name) {
        String parameter = req.getParameter(name);
        Assert.hasLength(parameter);
        return parameter;
    }
    
    public static ModelAndView getModelAndView(String subPath, String fileName, Map map) {
        Assert.hasText(fileName);
        if (map == null) {
            map = new HashMap(1);
        }
        if (StringUtils.isNotEmpty(subPath)) {
            map.put("subPath", subPath);
        }
        map.put("fileName", fileName);
        return new ModelAndView(subPath + "/" + fileName, map);
    }
    
    /**后台分页*/
    public static void putJSONPage(JSONConvert jsonConvert, Page page, List jsonAwareList, HttpServletResponse res) {
        JSONArray jsonArray = jsonConvert.modelCollect2JSONArray(page.getItems(), jsonAwareList);
        putJSONArray(page.getTotalProperty(), jsonArray, res);
    }
    
    /**无记录*/
    public static void putJSONListEmpty(HttpServletResponse res) {
        putJSONArray(0, new JSONArray(), res);
    }
     
    /**用于List已经全部拿到，只需要转换部分分页数据
     * @param jsonConvert
     * @param list
     * @param jsonAwareList
     * @param req
     * @param res
     */
    public static void putJSONList(JSONConvert jsonConvert, List list, List jsonAwareList, HttpServletRequest req,
            HttpServletResponse res) {
        PageParam pageParam = getPageParam(req);
        JSONArray jsonArray = jsonConvert.modelCollect2JSONArray(
                list.subList(pageParam.getStart(), Math.min(list.size(), pageParam.getEnd())), jsonAwareList);
        putJSONArray(list.size(), jsonArray, res);
    }
    
    /**用于不需要分页的情况
     * @param jsonConvert
     * @param list
     * @param jsonAwareList
     * @param res
     */
    public static void putJSONList(JSONConvert jsonConvert, List list, List jsonAwareList, HttpServletResponse res) {
        JSONArray jsonArray = jsonConvert.modelCollect2JSONArray(list, jsonAwareList);
        putJSONArray(jsonArray.size(), jsonArray, res);
    }
     
    public static void putJSONArray(int totalProperty, JSONArray jsonArray, HttpServletResponse res) {
        putJSONArray(totalProperty, jsonArray, res, null);
    }
    
    public static void putJSONArray(int totalProperty, JSONArray jsonArray, HttpServletResponse res, Map map) {
        if (map == null) {
            map = new HashMap(2);
        }
        map.put("totalProperty", "" + totalProperty);
        map.put("root", jsonArray);
        putJSON(map, res);
    }
    
    
    /**
     * 用于表单的值通过Json对象回填
     * @param jsonConvert
     * @param model
     * @param jsonAwareList
     * @param res
     */
    public static void putJSONListByModel(JSONConvert jsonConvert, Object object, List jsonAwareList, HttpServletResponse res) {
        List list = new LinkedList();
        list.add(object);
        JSONArray jsonArray = jsonConvert.modelCollect2JSONArray(list, jsonAwareList);
        putJSONModel(jsonArray, res, null);
    }
    
    public static void putJSONModel(JSONArray jsonArray, HttpServletResponse res, Map map) {
        if (map == null) {
            map = new HashMap(2);
        }
        map.put("success", new Boolean(true));
        map.put("data", jsonArray);
        putJSON(map, res);
    }
    
    public static void putJSONResult(boolean isSuccess, Object data, HttpServletResponse res) {
        Map map = new HashMap(2);
        if (isSuccess) {
            map.put("success", "true");
        } else {
            map.put("success", "false");
        }
        map.put("data", data);
        putJSON(map, res);
    }
    
    public static void putJSON(Map map, HttpServletResponse res) {
        putJSON(JSONObject.fromObject(map), res);
    }
    
    public static void putJSON(JSONObject jsonObject, HttpServletResponse res) {
        writeStr2Res(jsonObject.toString(), res);
    }
    
    public static void putJSON(JSONArray jsonArray, HttpServletResponse res) {
        writeStr2Res(jsonArray.toString(), res);
    }
    
    public static void writeStr2Res(String jsonStr, HttpServletResponse res) {
        res.setContentType("text/html");
        try {
            res.getWriter().write(jsonStr);
        } catch (IOException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }
    
    public static PageParam getPageParam(HttpServletRequest req) {
        PageParam pageParam = new PageParam();
        pageParam.setStart(ServletRequestUtils.getIntParameter(req, "start", 0));
        pageParam.setPage(ServletRequestUtils.getIntParameter(req, "page", 1));
        pageParam.setLimit(ServletRequestUtils.getIntParameter(req, "limit", NUM_PER_PAGE));
        pageParam.setSort(ServletRequestUtils.getStringParameter(req, "sort", ""));
        pageParam.setDir(ServletRequestUtils.getStringParameter(req, "dir", ""));
        return pageParam;
    }
    
    /**内存级的分页策略，一次取出所有数据，考虑到延迟加载和页面显示的需要
     * httpSession中放的是jsonConvert以后的数据
     * 
     * 如果request中参数start > 0，才考虑从缓存取数据
     * 如果缓存中的JSONArray为空，从数据库取数据
     * 反之取缓存中的JSONArray
     * 取的数据根据request中的参数start和limit
     * limit参数不传的话默认为20，页面上pageSize的默认值利用EXT的默认值20
     * @param jsonConvert
     * @param req
     * @param res
     * @param handler 通过实现这个内部类，当需要从数据库中取数据的话，调用实现的方法
     * @deprecated
     */
    public static void getAndPutJSONArrayCache(JSONConvert jsonConvert, HttpServletRequest req, HttpServletResponse res, FindListHandler handler,
            List jsonAwareList) {
        JSONArray[] jsonArrays = getJSONArrayCache(jsonConvert, req, handler, jsonAwareList);
        putJSONArray(jsonArrays[0].size(), jsonArrays[1], res);
    }
    
    private static JSONArray[] getJSONArrayCache(JSONConvert jsonConvert, HttpServletRequest req, FindListHandler handler, List jsonAwareList) {
        int start = ServletRequestUtils.getIntParameter(req, "start", 0);
        int limit = ServletRequestUtils.getIntParameter(req, "limit", NUM_PER_PAGE);
        
        String sessionName = getPrefixPrivate();
        JSONArray jsonArray = null;
        if (start > 0) {
            jsonArray = (JSONArray) req.getSession().getAttribute(sessionName);
        }
        if (jsonArray == null) {
            log.info("取数据库数据");//////////////////
            jsonArray = jsonConvert.modelCollect2JSONArray(handler.findList(), jsonAwareList);
            req.getSession().setAttribute(sessionName, jsonArray);
        } else {
            log.info("命中缓存");//////////////////
        }
        
        if (start < 0) {
            start = 0;
        }
        JSONArray pageJSONArray = new JSONArray();
        for (int i = start; i <= start + limit - 1 && i < jsonArray.size(); i++) {
            pageJSONArray.add(jsonArray.get(i));
        }
        return new JSONArray[] {jsonArray, pageJSONArray};
    }
    
    public static void putMsgMap(String msg, Map map) {
        map.put(REQUEST_MESSAGE, msg);
    }
    
    public static void putMsgMap(Exception ex, Map map) {
        map.putAll(getMsgMap(ex.getMessage()));
    }
    
    public static Map getMsgMap(String msg) {
        Map map = new HashMap(1);
        map.put(REQUEST_MESSAGE, msg);
        return map;
    }
    
    /**
     * 页面显示年份下拉框，默认值为当前年，页面显示起始年也是当前年，页面元素名称year
     * 用法:见my_result.ftl
     * @param req
     * @param map
     * @return int
     */
    public static int getAndPutSelectYear(HttpServletRequest req, Map map) {
        int nowYear = Calendar.getInstance().get(Calendar.YEAR);
        map.put("startYear", "" + nowYear);
        return Integer.parseInt(getStrAndPutInMapSessionAutoPrefix(req, "year", "" + nowYear, map));
    }
    
    /**
     * 页面显示月份下拉框，默认值是当前月份，起始月也是当前月，selected=month;
     * @param request
     * @param map
     * @return
     */
    public static int getAndPutSelectMonth(HttpServletRequest request, Map map) {
        int nowMonth = Calendar.getInstance().get(Calendar.MONTH);
        return Integer.parseInt(getStrAndPutInMapSessionAutoPrefix(request, "month", "" + nowMonth, map));
    }
    
    /**
     * 根据名称从request取出变量，如果request中没有数据，则从session中找，如果session中也没有，取默认值
     * 返回的同时执行map.put(name, value)，session.put(className + "." + methodName + "." + name, value)
     * @param req
     * @param name
     * @param defaultVal
     * @param map
     * @return
     */
    public static String getStrAndPutInMapSessionAutoPrefix(HttpServletRequest req, String name, String defaultVal, Map map) {
        String sessionName = getPrefixPrivate() + name;
        String value = getStrFromSession(req, sessionName, defaultVal);
        value = getStrAndPutInMap(req, name, value, map);
        req.getSession().setAttribute(sessionName, value);
        return value;
    }
    
    public static String getStrFromSessionAutoPrefix(HttpServletRequest req, String name, String defaultVal) {
        String sessionName = getPrefixPrivate() + name;
        return getStrFromSession(req, sessionName, defaultVal);
    }
    
    public static void putInSessionAutoPrefix(HttpServletRequest req, String name, Object value) {
        String sessionName = getPrefixPrivate() + name;
        req.getSession().setAttribute(sessionName, value);
    }
    
    /**
     * 根据名称从request取出变量，返回的同时执行map.put(name, value)，有默认值
     * @param req
     * @param name
     * @param defaultValue
     * @param map
     * @return
     */
    public static String getStrAndPutInMap(HttpServletRequest req, String name, String defaultVal, Map map) {
        String value = ServletRequestUtils.getStringParameter(req, name, defaultVal);
        map.put(name, value);
        return value;
    }
    
    /**
     * 根据名称，从request取出变量，有默认值
     * @param req
     * @param name
     * @param defaultVal
     * @return
     */
    public static String getStrFromSession(HttpServletRequest req, String name, String defaultVal) {
        String value = (String) req.getSession().getAttribute(name);
        if (value == null) {
            return defaultVal;
        }
        return value;
    }
    
//    public static User getUser(HttpServletRequest req) {
//        return (User) req.getSession().getAttribute(SESSION_USER);
//    }
//    
//    public static void setUser(HttpServletRequest req, User user) {
//        req.getSession().setAttribute(SESSION_USER, user);
//    }
    
    /**
     * 得到当前所需前缀，例：
     * public class UserCtrl {
     *     public List findList() {
     *         System.out.println(Ctrl.getPrefix());
     *     };
     * }
     * 打印输出“UserCtrl.findList.”
     * @return 前缀
     * @deprecated
     */
    private static String getPrefixPrivate() {
        StackTraceElement ste = new Throwable().getStackTrace()[2];
        return ste.getClassName() + "." + ste.getMethodName() + ".";
    }
    
    public static String getPrefix() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getClassName() + "." + ste.getMethodName() + ".";
    }
     
    /**
     * 得到堆栈中第三个调用的类名，效果如下：
     * public class UserCtrl {
     *     public List findList() {
     *         System.out.println(Ctrl.getMethodName());
     *     };
     * }
     * 打印输出“UserCtrl”
     * @return
     */
    public static String getClassName() {
        return new Throwable().getStackTrace()[2].getClassName();
    }
    
    /**
     * 得到堆栈中第三个调用的方法名，效果如下：
     * public class UserCtrl {
     *     public List findList() {
     *         System.out.println(Ctrl.getMethodName());
     *     };
     * }
     * 打印输出“findList”
     * @return
     */
    public static String getMethodName() {
        return new Throwable().getStackTrace()[2].getMethodName();
    }
    
    public static boolean isFromMethod(String mothodName) {
        String methodName = new Throwable().getStackTrace()[2].getMethodName();
        return methodName.equals(mothodName);
    }
    
    public static boolean isNotFromMethod(String mothodName) {
        String methodName = new Throwable().getStackTrace()[2].getMethodName();
        return !methodName.equals(mothodName);
    }
    
    public static String testGetPrefix() {
        return getPrefixPrivate();
    }
    
    public static String testGetClassName() {
        return getClassName();
    }
    
    public static String testGetMethodName() {
        return getMethodName();
    }
    
    public static void main(String[] args) {
        System.out.println(testGetPrefix());
        System.out.println(testGetClassName());
        System.out.println(testGetMethodName());
    }

    public static BigDecimal movePointLeft(BigDecimal decimal){
        if (decimal != null) {
            return decimal.movePointLeft(2);
        } else {
            return BigDecimalUtils.ZERO;
        }
    }
    
}
