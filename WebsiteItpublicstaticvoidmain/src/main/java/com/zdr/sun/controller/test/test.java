package com.zdr.sun.controller.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // 作用与表现层,MVC注解
@RequestMapping("/test")
public class test {
	private static final Logger logger = LogManager.getLogger(test.class.getName());

	// 测试跳转
	@RequestMapping(value = "/test1")
	public String factorsippool() {
		logger.info("测试跳转1"); // info级别的信息
		return "tools/boke/weniian/index";
	}
}
