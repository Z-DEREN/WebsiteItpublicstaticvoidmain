package com.zdr.sun.service.qiniu;

import java.util.List;

import com.zdr.sun.pojo.qiniuyun.qiniuyun;

public interface QiniuService {

    /**
     * 向七牛云保存文件(将返回数据存储在数据库中)
     * 
     * @param niu
     * @return
     */
    public boolean addniufile(qiniuyun niu);

    /**
     * 读取七牛云中的所有文件
     * 
     * @param niu
     * @return
     */
    public List<qiniuyun> selectniufile();
}
