package com.zdr.sun.controller.Login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.zdr.sun.service.Lzuser.LzuserService;
import com.zdr.sun.pojo.Zuser.Zuser;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger logger = LogManager.getLogger(LoginController.class.getName());

	@Resource
	private LzuserService LzuserService;

	@RequestMapping(value = "/6c4b4baec9423e0f788d05a8178e4d01")
	public ModelAndView go(@RequestParam(value = "02777dd215647ddc8b63844bc9f289cc", required = false) String zusername,
			@RequestParam(value = "d1320cebfd37f60f0faac45c613eb86c", required = false) String zpassword,
			HttpSession session, HttpServletRequest request) {
		ModelAndView model = new ModelAndView();

		String host = request.getRemoteHost();
		logger.info("IP为---->>> " + host + " <<<-----访问了系统"); // info级别的信息
		logger.info(" 用户名:" + zusername + " 密码:" + zpassword
				+ "-----------------------------------------------------------"); // info级别的信息

		if ((zusername.equals("") || zusername == null) || (zpassword.equals("") || zpassword == null)) {
			logger.info(" 用户名或密码为空------------------------------------------------------------:"); // info级别的信息
			model.setViewName("login");// 返回登录页
			return model;
		}

		Zuser zuser = new Zuser();
		zuser = LzuserService.userselect(zusername, zpassword);

		if (zuser == null) {
			logger.info(" 用户输入账号或密码错误------------------------------------------------------------:"); // info级别的信息
			model.setViewName("login");// 返回登录页
			return model;
		}

		session.setAttribute("2aa83c25b2550a178ce8cae7342dd975", zuser);
		logger.info(" 用户登录成功------------------------------------------------------------:"); // info级别的信息
		model.setViewName("redirect:/login/loginByadmin");// 返回登录页
		return model;
	}

	@RequestMapping("/loginByadmin")
	public String loginByadmin(HttpServletRequest request, HttpServletResponse response) {
		logger.info(" 用户登录....------------------------------------------------------------:"); // info级别的信息
		return "Homethis/Homethis";
	}

}
