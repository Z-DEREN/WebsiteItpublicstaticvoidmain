package com.zdr.sun.tools.BaseDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.xml.bind.DataBindingException;

public class BaseDao {
	protected Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	// protected String driver = "com.mysql.jdbc.Driver";
	// protected String url = "jdbc:mysql://localhost:3306/tianyan?useSSL=true";
	// protected String dbUser = "root";
	// protected String dbPassword = "root";

	protected static String driver;
	protected static String url;
	protected static String dbUser;
	protected static String dbPassword;

	public void into() {
		Properties pr = new Properties();
		String f = "DB.properties";
		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(f);
		try {
			pr.load(is);
			driver = pr.getProperty("driver");
			url = pr.getProperty("url");
			dbUser = pr.getProperty("dbUser");
			dbPassword = pr.getProperty("dbPassword");

		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			pr.clear();
		}
	}

	/*
	 * 数据库连接
	 */
	public void connToDB() throws ClassNotFoundException, SQLException {
		into();
		Class.forName(driver);
		conn = DriverManager.getConnection(url, dbUser, dbPassword);
	}

	// 通用的增、删、改方法
	public int executeUpdate(String sql, Object[] param) {
		int result = 0;
		try {
			connToDB();
			pstmt = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			System.out.println("重复");
		} finally {
			close(this.conn, this.pstmt, this.rs);
		}
		return result;

	}

	// 通用查询方法

	public ResultSet select(String sql, Object[] param) {
		try {
			connToDB();
			pstmt = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					pstmt.setObject(i + 1, param[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		//
		return rs;
	}

	/*
	 * 关闭
	 */
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}
