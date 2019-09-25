package com.zdr.sun.service.util;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.zdr.sun.dao.util.utilMapper;
import com.zdr.sun.pojo.util.util;

@Service
public class utilServiceImpl implements utilService {

	@Resource
	private utilMapper utilMapper;

	/**
	 * 验证表唯一id
	 * 
	 * @param ip
	 */
	public boolean tableID(util util) {
		boolean tf = false;
		if (utilMapper.tableID(util) > 0) {
			tf = true;
		}
		System.out.println(tf);
		return tf;
	}
}
