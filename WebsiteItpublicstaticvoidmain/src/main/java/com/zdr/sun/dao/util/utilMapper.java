package com.zdr.sun.dao.util;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zdr.sun.pojo.util.util;

@Repository // 连接数据库注解
public interface utilMapper {
	/**
	 * 验证表唯一id
	 * 
	 * @param ip
	 */
	public int tableID(util util);
}
