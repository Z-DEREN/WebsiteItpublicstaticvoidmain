package com.zdr.sun.dao.Kr36;

import org.springframework.stereotype.Repository;

import com.zdr.sun.pojo.Kr36.news24th;

/**
 * 
 * @author 好人
 *
 */
@Repository // 连接数据库注解
public interface Kr36Mapper {

    // 获取新闻总数
    public int getnewsCount() throws Exception;

    // 存储新闻
    public int insert(news24th news) throws Exception;

    // 获取数据库内最新新闻的id作为爬取起点
    public Integer read() throws Exception;

}
