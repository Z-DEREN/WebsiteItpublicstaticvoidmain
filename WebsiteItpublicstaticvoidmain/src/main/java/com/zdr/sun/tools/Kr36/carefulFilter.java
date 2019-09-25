package com.zdr.sun.tools.Kr36;

/*
 * 细提取方法:将内容提取出来
 * 导入粗提取的值
 * 返回筛选后的值
 * */
import java.util.ArrayList;
import java.util.List;

public class carefulFilter {
    public int front;
    public int later;
    public String textno1;
    // 所提取的值
    public String time;// created_at
    public String ID;// id
    public String title;// title
    public String summary;// summary
    public String url;// url

    public List saix(String information) {
	List<String> list = new ArrayList<String>();

	// title
	front = information.indexOf("title\":\"");
	later = information.indexOf("catch_title");
	if (front != -1 && later != -1) { // 判断是否为要爬取的目标
	    title = information.substring(front + 8, later - 3);

	    // ID
	    front = information.indexOf("id\":");
	    later = information.indexOf(",\"");
	    ID = information.substring(front + 4, later);

	    // summary
	    front = information.indexOf("description");
	    later = information.indexOf("cover");
	    summary = information.substring(front + 14, later - 3);

	    // url
	    front = information.indexOf("\"news_url\":\"http");
	    later = information.indexOf("user_id");
	    if (front != -1) {
		url = information.substring(front + 12, later - 3);
	    } else {
		url = "null";
	    }
	    // time
	    front = information.indexOf("created_at");
	    later = information.indexOf("updated_at");
	    time = information.substring(front + 13, later - 3);

	    list.add(ID);
	    list.add(title);
	    list.add(summary);
	    list.add(url);
	    list.add(time);
	}
	return list;
    }

}
