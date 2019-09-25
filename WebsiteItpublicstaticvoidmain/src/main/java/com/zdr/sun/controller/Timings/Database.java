package com.zdr.sun.controller.Timings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 作用与表现层,MVC注解
@RequestMapping("/Database")
public class Database {
	private static final Logger logger = LogManager.getLogger(Database.class.getName());

	
	
	
	
	// 测试跳转
	@RequestMapping(value = "/Connect")
	public String Connect() {
		
		
		
		
		
		return null;
	}

}