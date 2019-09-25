package com.zdr.sun.tools.Kr36;

/*
 * 此方法为最简单的爬虫方法,只适用于静态网页
 * 
 * 
爬取方法
此方法为无需登陆的爬取方法
使用ignoreContentType(true)
使用get()
header为模仿浏览器头
导入String类型的地址如http://XXX.com
返回String类型网址的html源码(不含js加载后的html代码)


 * */

/**
 * @author 好人
 * @oaram String url
 * @return 网址源码
 */
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class crawler {

    public String crawler(String url) {
	String text = "";

	Document doc;
	try {
	    doc = Jsoup.connect(url)
		    .header("user-agent",
			    "Mozilla/5.0 (Windows NT 10.0; WOW64) " + "AppleWebKit/537.36 (KHTML, like Gecko) "
				    + "Chrome/47.0.2526.106 BIDUBrowser/8.7 Safari/537.36")
		    .ignoreContentType(true).get();
	    text = doc.html();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return text;
    }
}
