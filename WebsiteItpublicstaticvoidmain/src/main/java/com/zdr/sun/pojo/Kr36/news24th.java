package com.zdr.sun.pojo.Kr36;

import java.util.List;

public class news24th {
    private String ID;// 新闻ID
    private String title;// 新闻标题
    private String neirong;// 新闻内容
    private String url;// 新闻附带连接
    private String time; // 新闻更新时间

    // 通知信息使用
    private int NewsCount; // 记录当前新闻获取数量
    private List<news24th> listnews; // 记录当前爬取详情

    public news24th() {

    }

    public news24th(String ID, String title, String neirong, String url, String time) {
	this.ID = ID;
	this.title = title;
	this.neirong = neirong;
	this.url = url;
	this.time = time;
    }

    public int getNewsCount() {
	return NewsCount;
    }

    public void setNewsCount(int newsCount) {
	NewsCount = newsCount;
    }

    public List<news24th> getListnews() {
	return listnews;
    }

    public void setListnews(List<news24th> listnews) {
	this.listnews = listnews;
    }

    public String getID() {
	return ID;
    }

    public void setID(String iD) {
	ID = iD;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getNeirong() {
	return neirong;
    }

    public void setNeirong(String neirong) {
	this.neirong = neirong;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    public String getTime() {
	return time;
    }

    public void setTime(String time) {
	this.time = time;
    }
}
