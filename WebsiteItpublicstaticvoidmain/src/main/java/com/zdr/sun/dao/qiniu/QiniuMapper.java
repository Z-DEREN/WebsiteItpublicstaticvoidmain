package com.zdr.sun.dao.qiniu;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zdr.sun.pojo.qiniuyun.qiniuyun;

@Repository
public interface QiniuMapper {

    /**
     * 向七牛云保存文件(将返回数据存储在数据库中)
     * 
     * @param niu
     * @return
     */
    public int addniufile(qiniuyun niu);

    /**
     * 读取七牛云中的所有文件
     * 
     * @param niu
     * @return
     */
    public List<qiniuyun> selectniufile();

}
