package com.zdr.sun.tools.IPpool;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zdr.sun.controller.SysInterceptor.LoginFilter;
import com.zdr.sun.pojo.IPpool.Newips;
import com.zdr.sun.tools.util.utilid;

public class IpPool {
	Split Split = new Split();
	paqu paqu = new paqu();
	Newips Newips = new Newips();
	// 工具
	utilid utilid = new utilid();

	private static final Logger logger = LogManager.getLogger(IpPool.class.getName());

	public String ChinaIPs = "http://www.xicidaili.com/nn/";
	public String ChinaIP = "http://www.xicidaili.com/nt/";
	public String url = null;
	public String text = null;
	public List<Newips> list = null;
	public String newip;
	public int beginIndex;
	public int endIndex;
	public String textno1;
	public String textno2;
	public String textno3[];
	public String textno4[];
	public String ip;
	public String port;
	public String area;
	public String present;

	/**
	 * 筛选
	 * 
	 * @param text
	 */
	public void ip(String text) {
		beginIndex = text.indexOf("<tbody>");
		endIndex = text.indexOf("</tbody>");
		text = text.substring(beginIndex, endIndex);
		// System.out.println("源码" + text);
		textno3 = text.split("</tr>");
		for (int i = 1; i < textno3.length; i++) {
			China(textno3[i]);
		}
	}

	/**
	 * 保存到对象中,并保存
	 * 
	 * @param text
	 */
	public void China(String text) {
		text = text.replace("<td>", "");
		text = text.replace(" ", "");
		text = text.replace("	", "");
		text = text.replace("\n", "");
		text = text.replace("\r", "");
		text = text.replace("\t", "");
		textno4 = text.split("</td>");
		if (textno4.length > 2) {
			ip = textno4[1];
			port = textno4[2];

			endIndex = textno4[3].indexOf(">");
			if (endIndex > 0) {
				textno1 = textno4[3].substring(endIndex);
				endIndex = textno1.indexOf("</a>");
				area = textno1.substring(1, endIndex);
			} else {
				area = "未知";
			}
//			System.out.println("ip:" + ip);
//			System.out.println("port:" + port);
//			System.out.println("area:" + area);

			Newips.setIp(ip);
			Newips.setPort(port);
			Newips.setArea(area);
			String ss = utilid.getid("testchinaips");
//			System.out.println(ss);
			Newips.setId(ss);

			logger.debug("		获取国内IP-----" + ip + ":" + port + ":" + area);
			Split.addtetsChinaIP(Newips);
		}
	}

	/**
	 * 获取国内ip
	 */
	public void ChinaIPs() {
		for (int i = 1; i <= 5; i++) {
			ChinaIpno1(i);
			ChinaIpno2(i);
		}
	}

	public void ChinaIpno1(int i) {
		url = ChinaIPs + i;
		text = paqu.paqu(url);
		ip(text);
	}

	public void ChinaIpno2(int i) {
		url = ChinaIP + i;
		text = paqu.paqu(url);
		ip(text);
	}

	/**
	 * 测试国内ip
	 */
	public void testchinaips() {
		list = Split.Listtestchips();
		onetestip();

		int aaaa = 0;
		int bbbb = 0;
		int cccc = 0;
		int dddd = 0;
		int eeee = 0;

		for (Newips goodip : list) {
//			System.out.print(goodip.getId());
//			System.out.print(":");
//			System.out.print(goodip.getIp());
//			System.out.print(":");
//			System.out.print(goodip.getPort());
//			System.out.print(":");
//			System.out.println(goodip.getArea());
			// 测试ip、端口是否可连接
			System.getProperties().setProperty("http.proxyHost", goodip.getIp());
			System.getProperties().setProperty("http.proxyPort", goodip.getPort());
			long startTime = System.currentTimeMillis(); // 获取开始时间

			newip = paqu.ip();

			long endTime = System.currentTimeMillis(); // 获取结束时间

			// 首先判断连接消耗的时间,再判断
			Long time = endTime - startTime;

			if (time > 500) {
				aaaa++;
			} else if (time > 1000) {
				bbbb++;
			} else if (time > 1500) {
				cccc++;
			} else if (time > 2000) {
				dddd++;
			} else if (time > 2500) {
				eeee++;
			}

			if (endTime - startTime < 1000) {

				if (!newip.contains(present)) {
					// 将可用的国内ip添加到国内可用数据库
					goodip.setTime(time.intValue());

					goodip.setId(utilid.getid("formalchinaips"));

					logger.debug("	测试国内IP可用-----" + goodip.getId() + ":" + goodip.getPort() + ":" + goodip.getArea()
							+ ":" + time + "mm");
					Split.addgoodChinaIP(goodip);

//					System.out.println("可连接");
//					System.out.println("连接时间： " + (endTime - startTime) + "ms");
				} else {
//					System.out.println("超过最大响应时间");
					// 删除测试库内国内ip
					Split.deltestChinaIP(goodip);
				}

			} else {
				Split.deltestChinaIP(goodip);
//				System.out.println("连接超时");
			}

			System.out.println("=====================================");
		}

//		System.out.println(aaaa);
//		System.out.println(bbbb);
//		System.out.println(cccc);
//		System.out.println(dddd);
//		System.out.println(eeee);

	}

	/**
	 * 测试国内可用ip
	 */
	public void fromalchinaips() {
		list = Split.Listformalchips();
		onetestip();
		for (Newips goodip : list) {
			// 测试ip、端口是否可连接
			System.getProperties().setProperty("http.proxyHost", goodip.getIp());
			System.getProperties().setProperty("http.proxyPort", goodip.getPort());
			long startTime = System.currentTimeMillis(); // 获取开始时间
			newip = paqu.ip();
			long endTime = System.currentTimeMillis(); // 获取结束时间
			// 首先判断连接消耗的时间,再判断
			Long time = endTime - startTime;
			if (endTime - startTime < 1000) {
				if (!newip.contains(present)) {
					logger.debug("	对可用IP进行复查-----" + goodip.getId() + ":" + goodip.getPort() + ":" + goodip.getArea()
							+ ":" + time + "mm");
//					System.out.println("连接时间： " + (endTime - startTime) + "ms");
				} else {
//					System.out.println("超过最大响应时间");
					Split.delfromalChinaIP(goodip);
				}
			} else {
				Split.delfromalChinaIP(goodip);
//				System.out.println("连接超时");
			}
			System.out.println("=====================================");
		}
	}

	public void onetestip() {
		String text = paqu.ip();
		int beginIndex;
		int endIndex;
		beginIndex = text.indexOf("cip");
		endIndex = text.indexOf("\",");
		present = text.substring(beginIndex + 7, endIndex);
//		System.out.println("本地ip省市为:" + present);
	}

}
