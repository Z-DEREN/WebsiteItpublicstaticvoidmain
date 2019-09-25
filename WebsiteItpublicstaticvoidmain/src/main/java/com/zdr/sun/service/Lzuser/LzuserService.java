package com.zdr.sun.service.Lzuser;

import org.apache.ibatis.annotations.Param;

import com.zdr.sun.pojo.Zuser.Zuser;

public interface LzuserService {
    // 通过账号密码获取登录对象实体
    public Zuser userselect(@Param("zusername") String zusername, @Param("zpassword") String zpassword);
}
