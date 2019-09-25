package com.zdr.sun.tools.Kr36;

/*主程序
 * 三大步骤
 * 爬取
 * 处理
 * 保存数据库
 * 
 * 因为爬取时是爬取原数据库基础上的新信息
 * 所以爬取的步骤为
 * 1获取数据库最新的ID为最后信息
 * 2爬取当前网址的最新ID为新信息
 * 3处理ID信息
 * 4得到新的url进行爬取
 * 
 * 
 * */
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.zdr.sun.pojo.Kr36.news24th;
import com.zdr.sun.service.Kr36.Kr36Service;
import com.zdr.sun.tools.ApplicationContextHelper.ApplicationContextHelper;

@Controller
public class principal {

	Kr36Service Kr36Service = ApplicationContextHelper.getBean(Kr36Service.class);

	// 创建对象
	crawler crawler = new crawler();
	news24th news24th = new news24th();

	// 粗细筛选
	roughFilter roughFilter = new roughFilter();
	carefulFilter carefulFilter = new carefulFilter();

	public news24th flow() {
		int ID = 0;
		int NEWID = 0;
		try {
			ID = Kr36Service.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 获数据库最新的ID
		NEWID = newID(); // 当前网址的最新ID
		String url = newurl(ID, NEWID); // 处理并返回新网址
		news24th = save(url);// 保存数据库方法
		// 记录当前新闻获取数量
		return news24th;
	}

	// 当前网址的最新ID
	public int newID() {
		int front = 0;
		int later = 0;
		String textno1 = "";
		String newsURL = "https://36kr.com/newsflashes";
		String newnum = crawler.crawler(newsURL);
		front = newnum.indexOf("newsflashList");
		textno1 = newnum.substring(front);
		front = textno1.indexOf("id");
		later = textno1.indexOf("project_id");
		textno1 = textno1.substring(front + 5, later - 2);
		front = Integer.parseInt(textno1);
		return front;
	}

	// 处理并返回新网址
	public String newurl(int ID, int NEWID) {
		String http = "https://36kr.com/api/newsflash?b_id=AAAA&per_page=BBBB";
		String BBBB = "";
		if (ID == 0) {
			BBBB = "100";
		} else {
			BBBB = String.valueOf(NEWID - ID);
		}

		http = http.replace("AAAA", String.valueOf(NEWID));
		http = http.replace("BBBB", BBBB);
		return http;

	}

	public news24th save(String newurl) {
		String information;
		int front = 0;
		int later = 0;
		int NewsCount = 0;
		List<String> Clist = new ArrayList<>();
		List<String> Xlist = new ArrayList<>();
		information = crawler.crawler(newurl);
		Clist = roughFilter.saix(information);

		// 记录当前爬取详情
		List<news24th> list = new ArrayList<>();

		for (String str : Clist) {
			front = str.indexOf("title\":\"");
			later = str.indexOf("catch_title");
			if (front != -1 && later != -1) {
				Xlist = carefulFilter.saix(str);
				// System.out.println(" 36kr爬虫信息 " + Xlist.get(0));
				System.out.println("		36kr爬虫信息		" + Xlist.get(1));
				// System.out.println(" 36kr爬虫信息 " + Xlist.get(2));
				// System.out.println(" 36kr爬虫信息 " + Xlist.get(3));
				// System.out.println(" 36kr爬虫信息 " + Xlist.get(4));

				news24th = new news24th(Xlist.get(0), Xlist.get(1), Xlist.get(2), Xlist.get(3), Xlist.get(4));

				try {
					if (Kr36Service.insert(news24th)) {
						list.add(news24th);
						NewsCount++;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		news24th.setListnews(list);
		news24th.setNewsCount(NewsCount);
		System.out.println("结束");
		return news24th;
	}

}
