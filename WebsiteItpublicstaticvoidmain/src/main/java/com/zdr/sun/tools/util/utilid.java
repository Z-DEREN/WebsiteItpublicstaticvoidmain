package com.zdr.sun.tools.util;

import org.apache.commons.lang.RandomStringUtils;

import com.zdr.sun.pojo.util.util;
import com.zdr.sun.service.util.utilService;
import com.zdr.sun.tools.ApplicationContextHelper.ApplicationContextHelper;

public class utilid {

	utilService utilsql = ApplicationContextHelper.getBean(utilService.class);

	/**
	 * 获取对应表的新id 并对新id进行测试
	 * 
	 * @param table
	 * @param id
	 * @return
	 */
	public String getid(String table) {
		String newoneid = "";
		boolean tf = true;

		util util = new util();
		util.setTable(table);
		do {
			newoneid = RandomStringUtils.randomAlphanumeric(18);
			util.setId(newoneid);
			tf = utilsql.tableID(util);
		} while (tf);

		return newoneid;

	}

}
