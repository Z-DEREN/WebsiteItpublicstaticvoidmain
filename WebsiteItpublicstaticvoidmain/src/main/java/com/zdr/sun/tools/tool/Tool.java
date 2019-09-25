package com.zdr.sun.tools.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Tool {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	
	private static final Logger logger = LogManager.getLogger(Tool.class.getName());

	

	private static SimpleDateFormat DT1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat DT2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static SimpleDateFormat DT3 = new SimpleDateFormat("HH:mm:ss");
	private static SimpleDateFormat DT4 = new SimpleDateFormat("HH:mm");

	private static Map<String, SimpleDateFormat> DTMap = new HashMap<String, SimpleDateFormat>();

	/**
	 * 静态代码块 (存入缓存当中)
	 */
	static {
		logger.info(" 静态代码块启动------------------------------------------------------------"); // info级别的信息
		// 初始化时间模式Map
		DTMap.put("DT1", DT1);
		DTMap.put("DT2", DT2);
		DTMap.put("DT3", DT3);
		DTMap.put("DT4", DT4);
	}

	// 数据库数据整理方法

	/**
	 * Sql查询方法
	 * <p>
	 * ListMap
	 * </p>
	 * <p>
	 * ArrayObject
	 * </p>
	 * <p>
	 * HashMap
	 * </p>
	 * <p>
	 * ArrayList
	 * </p>
	 * <p>
	 * String
	 * </p>
	 * 
	 * @param Sql
	 * @param Value
	 * @return
	 */
	public Object GetArrayListSql(String sql, Object[] Value, String type) {
		// listmap
		List<Map<String, Object>> ListMap = new ArrayList<Map<String, Object>>();
		// list
		List<Object> ArrayObject = new ArrayList<Object>();
		// map
		Map<String, Object> HashMap = new HashMap<String, Object>();
		// array
		Object[] ArrayList = null;

		if (Value == null) {
			System.out.println("执行的SQL为:"+sql);
			logger.info("执行的SQL为:"+sql); // info级别的信息
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		} else {
			System.out.println("执行的SQL为:"+sql);
			String sqlvalue = "执行的SQL为:"+sql+"; 值为:";
			for(Object value : Value){
				sqlvalue+= value+" , ";
			} 
			logger.info(sqlvalue); // info级别的信息
			List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, Value);
		}
		
//		for (Map<String, Object> map : list) {
//			Map<String, Object> AddMap = new HashMap<String, Object>();
//			Set<Entry<String, Object>> entries = map.entrySet();
//			if (entries != null) {
//				Iterator<Entry<String, Object>> iterator = entries.iterator();
//				while (iterator.hasNext()) {
//					Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
//					Object key = entry.getKey();
//					Object value = entry.getValue();
//					System.out.println(key + ":" + value);
//					AddMap.put(key.toString(), value);
//					HashMap.put(key.toString(), value);
//					ArrayObject.add(value);
//				}
//			}
//			ListMap.add(AddMap);
//		}

		switch (type) {
		case "ListMap":
			return ListMap;
		case "ArrayObject":
			ArrayList = new Object[ArrayObject.size()];
			ArrayObject.toArray(ArrayList);
			return ArrayObject;
		case "HashMap":
			return HashMap;
		case "ArrayList":
			return ArrayList;
		case "String":
			return ArrayObject.get(0);
		default:
			System.out.println(" Tool Sql查询方法 - 返回类型值有误 ");
			logger.info(" Tool Sql查询方法 - 返回类型值有误 "); // info级别的信息
			return "null";
		}
	}

	/**
	 * 新建时间格式化方法
	 * 
	 * @param type 对应类型
	 *             <p>
	 *             1 yyyy-MM-dd
	 *             </p>
	 *             <p>
	 *             2 yyyy-MM-dd HH:mm:ss
	 *             </p>
	 *             <p>
	 *             3 HH:mm:ss
	 *             </p>
	 *             <p>
	 *             4 HH:mm:ss
	 *             </p>
	 * @return String 时间
	 */
	public String GetNewDateTime(int type) {
		String DateTime = "";
		Date date = new Date();
		DateTime = DTMap.get("DT" + type).format(date);
		return DateTime;
	}

	/**
	 * 指定时间格式化方法
	 * 
	 * @param type 对应类型
	 * @param date 指定时间
	 *             <p>
	 *             1 yyyy-MM-dd
	 *             </p>
	 *             <p>
	 *             2 yyyy-MM-dd HH:mm:ss
	 *             </p>
	 *             <p>
	 *             3 HH:mm:ss
	 *             </p>
	 *             <p>
	 *             4 HH:mm:ss
	 *             </p>
	 * @return String 时间
	 */
	public String GetNewDateTime(int type, String date) {
		String DateTime = "";
		try {
			Date sDate = DT2.parse(date);
			DateTime = DTMap.get("DT" + type).format(sDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DateTime;
	}

}
