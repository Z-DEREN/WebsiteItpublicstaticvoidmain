package com.zdr.sun.controller.SysInterceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zdr.sun.pojo.Zuser.Zuser;

@Controller
public class LoginInterceptor implements HandlerInterceptor {

	// 日志
	private static final Logger logger = LogManager.getLogger(LoginInterceptor.class.getName());

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("执行完毕，返回前拦截");
		// 执行完毕，返回前拦截
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {

		System.out.println("处理过程执行拦截");
		// 在处理过程中，执行拦截
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

		String host = request.getRemoteHost();
		String requestUri = request.getRequestURI(); // 请求完整路径，可用于登陆后跳转
		String contextPath = request.getContextPath(); // 项目下完整路径
		String url = requestUri.substring(contextPath.length()); // 请求页面

		// 通过转换，获取用户的请求URL地址
		logger.info("%%%%%%%%%%%%%IP为---->>> " + host + " <<<-----访问了系统%%%%%%%%%%%%%"); // info级别的信息

		HttpSession session = request.getSession();
		Zuser zuser = new Zuser();
		zuser = (Zuser) session.getAttribute("2aa83c25b2550a178ce8cae7342dd975");
		logger.info("%%%%%%%%%%%%%发生拦截...访问了系统%%%%%%%%%%%%%"); // info级别的信息
		logger.info("%%%%%%%%%%%%%来自" + requestUri + "的请求%%%%%%%%%%%%%"); // info级别的信息

		if (zuser == null) { // 判断用户是否存在，不存在返回登录界面，继续拦截，存在通过拦截，放行到访问页面
			logger.info("%%%%%%%%%%%%%用户未登录%%%%%%%%%%%%%"); // info级别的信息
			/**
			 * 拦截目录下请求，是否为ajax请求 是：无需登录，直接访问（因为我是用于首页的ajax登录请求） 否：跳转至登录界面
			 */
			logger.info("%%%%%%%%%%%%%返回登录页...%%%%%%%%%%%%%"); // info级别的信息
			response.sendRedirect(request.getSession().getServletContext().getContextPath());
			return false;
		} else {
			logger.info("%%%%%%%%%%%%%用户已经登录.%%%%%%%%%%%%%"); // info级别的信息
			return true;
		}
	}

}
