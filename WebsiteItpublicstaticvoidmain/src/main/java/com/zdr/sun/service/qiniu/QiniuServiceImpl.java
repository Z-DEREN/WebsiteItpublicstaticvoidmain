package com.zdr.sun.service.qiniu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdr.sun.dao.qiniu.QiniuMapper;
import com.zdr.sun.pojo.qiniuyun.qiniuyun;
//import com.zdr.sun.tools.QiniuYun.Upload;

@Service
public class QiniuServiceImpl implements QiniuService {

    @Resource
    public QiniuMapper niumapper;

    /**
     * 向七牛云保存文件(将返回数据存储在数据库中)
     * 
     * @param niu
     * @return
     */
    @Override
    public boolean addniufile(qiniuyun niu) {
	// TODO Auto-generated method stub

//	Upload niupojo = new Upload();

	// 存储
//	niu = niupojo.Upload(niu.getLocal());

	boolean tf = false;
	if (niumapper.addniufile(niu) > 0) {
	    tf = true;
	}
	return tf;
    }

    /**
     * 读取七牛云中的所有文件
     * 
     * @param niu
     * @return
     */
    @Override
    public List<qiniuyun> selectniufile() {
	// TODO Auto-generated method stub
	return null;
    }

}
