package net.ufida.x27.util.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TokenProcessorUtils {
	private Log log = LogFactory.getLog(this.getClass());

    // TOKEY KEY
    public static final String TOKEN_KEY = "token";

    private static TokenProcessorUtils instance = new TokenProcessorUtils();

    // 最近一次生成令牌的时间
    private long previous;

    public static TokenProcessorUtils getInstance() {
        return instance;
    }

    /**
     * 判断当前令牌是否合法
     * @param request
     * @return
     */
    public synchronized boolean tokenIsValid(HttpServletRequest request) {
        // 得到请求的当前session对象
        HttpSession session = request.getSession(false);

        log.debug("isTokenValid session:" + session);
        if (session == null) {
            return false;
        }

        String sessionTokenValue = (String) session.getAttribute(TOKEN_KEY);
        log.debug("isTokenValid sessionTokenValue:" + sessionTokenValue);
        if (StringUtils.isEmpty(sessionTokenValue) == true) {
            return false;
        }

        // 清除session中的令牌值
        resetToken(request);

        // 得到请求参数中的令牌值
        String token = request.getParameter(TOKEN_KEY);
        log.debug("isTokenValid token:" + token);
        if (StringUtils.isEmpty(token) == true) {
            return false;
        }

        return sessionTokenValue.equals(token);
    }

    /**
     * 重置session中的令牌值
     * @param request
     */
    public synchronized void resetToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        log.debug("resetToken session:" + session);
        if (session == null) {
            return;
        }
        session.removeAttribute(TOKEN_KEY);
    }

    /**
     * 保存令牌值
     * @param request
     */
    public synchronized void saveToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String token = generateToken(request);
        if (token != null) {
            session.setAttribute(TOKEN_KEY, token);
        }
    }

    /**
     * 生成令牌值
     * @param request
     * @return
     */
    public synchronized String generateToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        try {
            byte id[] = session.getId().getBytes();
            long current = System.currentTimeMillis();
            if (current == previous) {
                current++;

            }
            previous = current;
            byte now[] = new Long(current).toString().getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(id);
            md.update(now);
            return toHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将一个字节数组转换一个十六进制数字的字符串
     * @param buffer
     * @return
     */
    private String toHex(byte buffer[]) {
        StringBuffer sb = new StringBuffer(buffer.length * 2);
        for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
        }

        return sb.toString();
    }

    /**
     * 获取令牌值
     * @param request
     * @return
     */
    public synchronized String getToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }

        String token = (String) session.getAttribute(TOKEN_KEY);

        if (StringUtils.isEmpty(token) == true) {
            token = generateToken(request);
            if (StringUtils.isNotEmpty(token) == true) {
                session.setAttribute(TOKEN_KEY, token);
                return token;
            } else
                return null;
        } else
            return token;
    }
}
