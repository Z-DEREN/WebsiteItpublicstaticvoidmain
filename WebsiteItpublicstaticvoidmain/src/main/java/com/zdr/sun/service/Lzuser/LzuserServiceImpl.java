package com.zdr.sun.service.Lzuser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdr.sun.dao.LzuserMapper.LzuserMapper;
import com.zdr.sun.pojo.Zuser.Zuser;
import com.zdr.sun.tools.MD5.MD5;

@Service
public class LzuserServiceImpl implements LzuserService {

    @Resource
    private LzuserMapper LzuserMapper;

    /**
     * 获取登录后对象实体
     */
    @Override
    public Zuser userselect(String zusername, String zpassword) {

	String zpasswords = MD5.Encode(zpassword);

	// TODO Auto-generated method stub
	return LzuserMapper.userselect(zusername, zpasswords);
    }

}
