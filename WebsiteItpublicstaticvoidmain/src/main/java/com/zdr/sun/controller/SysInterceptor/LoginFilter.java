package com.zdr.sun.controller.SysInterceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zdr.sun.pojo.Zuser.Zuser;

public class LoginFilter implements Filter {

	private static final Logger logger = LogManager.getLogger(LoginFilter.class.getName());

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String requestUri = request.getRequestURI(); // 请求完整路径，可用于登陆后跳转
		String host = request.getRemoteHost();
		// 通过转换，获取用户的请求URL地址

		logger.info("&&&&&&&&&&&&&&&&&&IP为---->>> " + host + " <<<-----访问了系统&&&&&&&&&&&&&&&&&&"); // info级别的信息
		System.out.println("IP为---->>> " + host + " <<<-----访问了系统");

		HttpSession session = request.getSession();
		Zuser zuser = new Zuser();
		zuser = (Zuser) session.getAttribute("2aa83c25b2550a178ce8cae7342dd975");
		logger.info("&&&&&&&&&&&&&&&&&&发生拦截..&&&&&&&&&&&&&&&&&&"); // info级别的信息
		logger.info("&&&&&&&&&&&&&&&&&&" + "来自：" + requestUri + "的请求" + "&&&&&&&&&&&&&&&&&&"); // info级别的信息
		if (zuser == null) { // 判断用户是否存在，不存在返回登录界面，继续拦截，存在通过拦截，放行到访问页面
			System.out.println("用户未登录");
			/**
			 * 拦截目录下请求，是否为ajax请求 是：无需登录，直接访问（因为我是用于首页的ajax登录请求） 否：跳转至登录界面
			 */
			logger.info("&&&&&&&&&&&&&&&&&&返回登录页....&&&&&&&&&&&&&&&&&&"); // info级别的信息
			response.sendRedirect(request.getSession().getServletContext().getContextPath());
		} else {
			logger.info("&&&&&&&&&&&&&&&&&&用户已经登录&&&&&&&&&&&&&&&&&&"); // info级别的信息
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
