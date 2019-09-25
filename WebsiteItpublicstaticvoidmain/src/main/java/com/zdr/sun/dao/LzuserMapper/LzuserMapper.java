package com.zdr.sun.dao.LzuserMapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zdr.sun.pojo.Zuser.Zuser;

@Repository
public interface LzuserMapper {

    /**
     * 通过账号密码获取登录对象实体
     * 
     * @param zusername
     * @param zpassword
     * @return
     */
    public Zuser userselect(@Param("zusername") String zusername, @Param("zpassword") String zpassword);
}
