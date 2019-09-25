package com.zdr.sun.controller.Timings;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zdr.sun.dao.Cardetails.CardDao;
import com.zdr.sun.pojo.Kr36.news24th;
import com.zdr.sun.tools.Cardetails.Cardetails;
import com.zdr.sun.tools.EmalPop3.EmailType;
import com.zdr.sun.tools.IPpool.AcquireIp;
import com.zdr.sun.tools.Kr36.principal;
import com.zdr.sun.tools.tool.Tool;

import com.zdr.sun.service.Timings.DatabaseService;

@Component
@Lazy(false)
public class TimerTask {

	EmailType EmailType = new EmailType();
	news24th news24th = new news24th();
	CardDao CardDao = new CardDao();
	Tool Tool = new Tool();
	
	@Autowired
	private DatabaseService DatabaseService;
	
	private static final Logger logger = LogManager.getLogger(TimerTask.class.getName());

	@Scheduled(cron = "0 0/10 * * * ?") // 每十分钟一次
	public void testTask() {
		logger.info("233333" + ":现在时间是:" + Tool.GetNewDateTime(2) + "我是info信息"); // info级别的信息
	}
	
	/**
	 * 每五分钟检测数据库连接情况
	 */
	@Scheduled(cron = "0 0/5 * * * ?")
	public void Database_Connect() {
		if(DatabaseService.Connect()) {
			logger.info(Tool.GetNewDateTime(2) + "数据库连接正常"); // info级别的信息
		}else {
			logger.info(Tool.GetNewDateTime(2) + "数据库连接失败"); // info级别的信息
		}
	}
	
	
	/**
	 * 获取国内ip,测试国内ip
	 */
//	@Scheduled(cron = "0 0 1 * * ?")
	public void factorsippool1() {
		AcquireIp AcquireIp = new AcquireIp();
		AcquireIp.ChinaIPs();
		AcquireIp.testchinaips();
		AcquireIp.fromalchinaips();
	}

//	@Scheduled(cron = "0 0 9 * * ?")
	public void factorsippool2() {
		AcquireIp AcquireIp = new AcquireIp();
		AcquireIp.ChinaIPs();
		AcquireIp.testchinaips();
		AcquireIp.fromalchinaips();
	}

//	@Scheduled(cron = "0 0 17 * * ?")
	public void factorsippool3() {
		AcquireIp AcquireIp = new AcquireIp();
		AcquireIp.ChinaIPs();
		AcquireIp.testchinaips();
		AcquireIp.fromalchinaips();
	}

	int testinti = 0;

//	@Scheduled(cron = "0 0/30 9-20 * * ?") // 每天九点到晚八点,每五分钟一次
	public void testTask2() {
		testinti++;
		int NewsCount = 0;
		System.out.println("执行第" + testinti + "次");
		principal test = new principal();
		System.out.println(111);
		List<news24th> list = new ArrayList<>();
		Cardetails Cardetails = new Cardetails();
		
		// 开始
		
		
		Map<String, Object> MapObj1 = Cardetails.ZPusots(CardDao.TypeSqlCAR("36kr"), null);

		// 使用返回的map 从map中筛选出来数据
		for (int i = 0; true; i++) {
			if (MapObj1.containsKey("36krid" + i)) {
				news24th = new news24th(MapObj1.get("id" + i).toString(), MapObj1.get("title" + i).toString(),
						MapObj1.get("neirong" + i).toString(), MapObj1.get("url" + i).toString(),
						MapObj1.get("time" + i).toString());
				NewsCount++;
				list.add(news24th);
			} else {
				break;
			}
		}
		news24th.setListnews(list);
		news24th.setNewsCount(NewsCount);

		//
		System.out.println(222 + " " + news24th.getNewsCount());
		// 数量以及
		try {
			EmailType.Kr36Email(news24th.getNewsCount(), news24th.getListnews());
			logger.info("36Kr邮件" + " 执行第" + testinti + "次 "); // info级别的信息
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			EmailType.Type("Email", null);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
