package com.zdr.sun.service.Timings;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdr.sun.dao.Timings.DatabaseMapper;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	@Resource
    private DatabaseMapper DatabaseMapper;
	
	/**
	 * 数据库连接测试
	 * @return
	 */
	@Override
	public boolean Connect() {
		boolean tf = false;
		if (DatabaseMapper.Connect() > 0) {
		    tf = true;
		}
		return tf;
	}
}
