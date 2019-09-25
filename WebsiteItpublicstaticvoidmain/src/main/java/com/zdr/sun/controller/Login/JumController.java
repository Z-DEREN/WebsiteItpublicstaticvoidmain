package com.zdr.sun.controller.Login;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdr.sun.pojo.Zuser.Zuser;

@Controller
public class JumController {
	private static final Logger logger = LogManager.getLogger(JumController.class.getName());

	@RequestMapping(value = "/ufo233")
	public String go(HttpSession session) {
		logger.info(" 进入登录页面------------------------------------------------------------"); // info级别的信息
		Zuser zuser = new Zuser();
		zuser = (Zuser) session.getAttribute("2aa83c25b2550a178ce8cae7342dd975");
		if (zuser == null) { // 判断用户是否存在，不存在返回登录界面，继续拦截，存在通过拦截，放行到访问页面
			logger.info(" 用户未登录返回登录页...------------------------------------------------------------"); // info级别的信息
			return "login/falke";
		} else {
			logger.info(" 用户已经登录...------------------------------------------------------------"); // info级别的信息
			return "Homethis/Homethis";
		}
	}
}
