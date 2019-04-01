package com.jonas.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 【 Cookie工具类 】
 *
 * @author shenjy 2018/09/03
 */
public class CookieUtils {

    /**
     * 获取cookie值
     *
     * @param request
     * @param name
     * @return
     */
    public static String getValue(HttpServletRequest request, String name) {
        String value = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    try {
                        value = URLDecoder.decode(cookie.getValue(), "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                    break;
                }
            }
        }
        return value;
    }

    /**
     * 添加cookie
     * @param response
     * @param name
     * @param value
     */
	public static void addCookie(HttpServletResponse response, String name,
						  String value, String domain, int maxAge) {
		try {
			Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
			cookie.setPath("/");
			cookie.setDomain(domain);
			cookie.setMaxAge(maxAge);
			cookie.setHttpOnly(true);
			response.addCookie(cookie);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}
