package com.zdr.sun.tools.Session;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre) {

    }

    public RequestListener() {

    }

    public void requestInitialized(ServletRequestEvent sre) {
	// 将所有request请求都携带上httpSession
	((HttpServletRequest) sre.getServletRequest()).getSession();
	
	
	
    }

}
