package com.zdr.sun.tools.Session;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class lajisession {
    /**
     * 获取当前请求对象
     * 
     * @return
     */
    public static HttpServletRequest getRequest() {
	try {
	    return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	} catch (Exception e) {
	    return null;
	}
    }
}
