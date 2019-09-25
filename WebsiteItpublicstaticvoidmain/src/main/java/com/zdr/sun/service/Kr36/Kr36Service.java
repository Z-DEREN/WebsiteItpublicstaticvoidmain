package com.zdr.sun.service.Kr36;

import com.zdr.sun.pojo.Kr36.news24th;

public interface Kr36Service {
    /**
     * 获取新闻总数
     * 
     * @return
     * @throws Exception
     */
    public int getnewsCount() throws Exception;

    /**
     * 存储新闻
     * 
     * @param news
     * @return
     * @throws Exception
     */
    public boolean insert(news24th news) throws Exception;

    /**
     * 获取数据库内最新新闻的id作为爬取起点
     * 
     * @return
     * @throws Exception
     */
    public int read() throws Exception;
}
