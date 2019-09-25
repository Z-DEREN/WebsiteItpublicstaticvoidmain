package com.zdr.sun.dao.Cardetails;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.zdr.sun.tools.BaseDao.BaseDao;

public class CardDao extends BaseDao {

	public String TypeSqlCAR(String type) {
		String xml = "";
		switch (type) {
		case "36kr":
			xml = Sql36Kr();
			break;

		default:
			break;
		}
		return xml;
	}

	public String Sql36Kr() {
		Object[] param = {};
		ResultSet rs = null;
		String xml = "";
		try {
			rs = this.select("SELECT xml FROM cardetails WHERE id = 1", param);
			while (rs.next()) {
				xml = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return xml;
	}

}
