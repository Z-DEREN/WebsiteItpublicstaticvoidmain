package com.zdr.sun.service.util;

import org.apache.ibatis.annotations.Param;

import com.zdr.sun.pojo.util.util;

public interface utilService {
	/**
	 * 验证表唯一id
	 * 
	 * @param ip
	 */
	public boolean tableID(util util);
}
