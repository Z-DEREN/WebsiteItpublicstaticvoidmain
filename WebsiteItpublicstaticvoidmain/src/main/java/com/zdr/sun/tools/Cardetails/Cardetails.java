package com.zdr.sun.tools.Cardetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.zdr.sun.tools.BaseDao.BaseDao;

/**
 * ZDR2019_7_15 0.1 工具实体包
 * 
 * @author 好人
 *
 *         主要功能为: 1.提供参数存储对象 2.提供所需逻辑方法
 */
public class Cardetails extends BaseDao {
	public int beginIndex;// 前下标
	public int endIndex;// 后下标
	public int ArrNum = 1;// 运行逻辑条数
	public String filetxt;// 源码
	public String string1;// 参数存储1
	public String string2;// 参数存储2
	public String string3;// 参数存储3
	public String string4;// 参数存储4
	public String[] array1;// 数组存储1
	public String[] array2;// 数组存储2
	public String[] array3;// 数组存储3
	public List<String> showList = new ArrayList<String>();// list集合
	public List<String> Listno2 = new ArrayList<String>();// list集合
	public Map<String, Object> MapObj1 = new HashMap<String, Object>();// 集合存储1
	public Map<String, Object> MapObj2 = new HashMap<String, Object>();// 集合存储2show
	String header = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3704.400 QQBrowser/10.4.3587.400";

	public Map<String, Object> ZPusots(String filelist, String file) {
		string1 = OutPut(filelist, true, "");
		if (file.equals("") || file == null) {
			filetxt = OutPut(file, false, "");
		}
		array1 = string1.split("<NO1 ");
		/**
		 * 逻辑循环按照name中的值进行对应操作
		 */
		for (int num = 0; num < array1.length; num++) {
			forch(Names(array1[num]), TxtNo(array1[num]));
		}
		System.out.println("爬取结束");
		System.out.println("名称:" + MapObj2.get("名称"));
		System.out.println("版本号:" + MapObj2.get("版本号"));
		return MapObj1;
	}

	/**
	 * 循环逻辑
	 * 
	 * @param type 类型
	 * @param list 参数
	 */
	public void forch(String type, String[] list) {
		switch (type) {
		case "Rough":// 筛选
			Rough(list);
			break;
		case "Split":// 重复
			Split(list);
			break;
		case "Clear":// 整理
			Clear(list);
			break;
		case "Split_Rough":// 重复筛选
			Split_Rough(list);
			break;
		case "SqlList":// 数据库
			SqlList(list);
			break;
		case "Crawler":// 爬取方法
			Crawler(list);
			break;
		case "Calculate":// 数据拼接加减操作
			Calculate(list);
			break;

		default:
			break;
		}
		ArrNum++;
	}

	/**
	 * 规律筛方法(使用新方法)
	 * 
	 * @param txt
	 */
	public void Split(String[] test) {
		string1 = MapObj2.get(test[0]).toString();
		Boolean TF = true;
		do {
			if (string1.indexOf(test[1]) > 0) {
				Listno2.add(string1.substring(0, string1.indexOf(test[1])));
				string1 = string1.substring(string1.indexOf(test[1]) + test[1].length());
			} else {
				Listno2.add(string1);
				TF = false;
			}
		} while (TF);
		MapObj2.put(test[2], Listno2);
	}

	/**
	 * 数据库方法 1.0:增查功能 未考虑删改功能
	 * 
	 * @param list
	 */
	public void SqlList(String[] list) {
		switch (list[0]) {
		case "Select":// 读取
			SqlSelect(list);
			break;
		case "Insert":// 写入
			SqlInsert(list);
			break;
		}
	}

	public List<String> Split_plaint(String txt) {
		List<String> sqlList = new ArrayList<String>();
		Boolean TF = true;
		do {
			if (txt.indexOf("<!>") > 0) {
				sqlList.add(txt.substring(0, txt.indexOf("<!>")));
				txt = txt.substring(txt.indexOf("<!>") + 3);
			} else {
				sqlList.add(txt);
				TF = false;
			}
		} while (TF);
		return sqlList;
	}

	/**
	 * 执行写入语句
	 * 
	 * @param sql
	 * @return
	 */
	public List<String> SqlInsert(String[] sql) {

		List<String> sqlList = Split_plaint(sql[2]);
		List<String> sqltype = Split_plaint(sql[3]);
		string1 = sql[2];
		Boolean TF = true;
		List<String> insertSql = new ArrayList<String>();
		//
		for (int i = 0; true; i++) {
			if (MapObj2.containsKey(sqlList.get(0) + i)) {
				String sqlto = "insert into " + sql[1] + " ( ";
				String sqlvalue = "";
				TF = true;
				for (int j = 0; j < sqlList.size(); j++) {
					if (!MapObj2.get(sqlList.get(j) + i).equals("") && MapObj2.get(sqlList.get(j) + i) != null
							&& !MapObj2.get(sqlList.get(j) + i).equals(" ")) {
						// 进行数据组装
						sqlto = sqlto + " " + sqlList.get(j) + " ,";
						if (sqltype.get(j).equals("Int")) {
							sqlvalue = sqlvalue + " " + MapObj2.get(sqlList.get(j) + i) + " ,";
						} else {
							sqlvalue = sqlvalue + " \"" + MapObj2.get(sqlList.get(j) + i) + "\" ,";
						}
					} else {
						TF = false;
						break;
					}
				}
				if (TF) {
					// 数据没有问题进行最后组装 并写入数据库
					sqlto = sqlto.substring(0, sqlto.length() - 1);
					sqlvalue = sqlvalue.substring(0, sqlvalue.length() - 1);
					insertSql.add(sqlto + " ) value ( " + sqlvalue + " ) ");
				}
			} else {
				break;
			}
		}
		Object[] param = {};

		for (String ss : insertSql) {
			int rs = this.executeUpdate(ss, param);
			if (rs > 0) {
				System.out.println("入库成功");
			}
		}

		return null;
	}

	/**
	 * 数据拼接加减操作
	 * 
	 * @param list
	 */
	public void Calculate(String[] list) {
		System.out.println("数据拼接加减操作");
		int num = 0;
		if (list[0].equals("int")) {
			// 进行加减操作
			int no1 = Integer.parseInt(MapObj2.get(list[1]).toString());
			int no2 = Integer.parseInt(MapObj2.get(list[3]).toString());
			switch (list[2]) {
			case "-":
				num = no1 - no2;
				break;
			case "+":
				num = no1 + no2;
				break;
			case "*":
				num = no1 * no2;
				break;
			case "/":
				num = no1 / no2;
				break;
			default:
				break;
			}
			MapObj2.put(list[4], num + "");
		} else if (list[0].equals("String")) {
			MapObj2.put(list[4], list[1] + list[3]);
		}
	}

	/**
	 * 执行查询语句
	 * 
	 * @param sql
	 * @return
	 */
	public List<String> SqlSelect(String[] sql) {
		Object[] param = {};
		ResultSet rs = null;
		try {
			rs = this.select(sql[1], param);
//			int i = 1;
			while (rs.next()) {
				MapObj2.put(sql[3], rs.getString(1));
//				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 重复筛选
	 * 
	 * @param test
	 */
	public void Split_Rough(String[] test) {
		List<String> list = new ArrayList<String>();
		list = (List<String>) MapObj2.get(test[0]);
		for (int i = 0; i < list.size(); i++) {
			MapObj2.put(test[0] + i, list.get(i));
			forch("Rough", new String[] { test[0] + i, test[1], test[2], test[3], test[4], test[5] + i });
			forch("Clear", new String[] { test[5] + i, test[5] + i });
		}
	}

	/**
	 * 筛选方法
	 * 
	 * @param txt
	 */
	public void Rough(String[] test) {
		if (test[0].equals("") || test[0] == null) {
			System.out.println("Card-----工具包ArraySys:" + "逻辑第" + ArrNum + "句,第一个参数为空");
		} else if (test[1].equals("") || test[1] == null) {
			System.out.println("Card-----工具包ArraySys:" + "逻辑第" + ArrNum + "句,第二个参数为空");
		} else if (test[2].equals("") || test[2] == null) {
			System.out.println("Card-----工具包ArraySys:" + "逻辑第" + ArrNum + "句,第三个参数为空");
		} else if (test[3].equals("") || test[3] == null) {
			System.out.println("Card-----工具包ArraySys:" + "逻辑第" + ArrNum + "句,第四个参数为空");
		} else if (test[0].equals("null")) {
			string1 = Indsub(filetxt, test[1], test[2], test[3], test[4]);
			MapObj2.put(test[5], string1);
		} else {
			if (!MapObj2.containsKey(test[0])) {
				System.out.println("Card-----工具包ArraySys:" + "逻辑第" + ArrNum + "句,未找到第一个参数存储的数据");
			} else {
				string1 = Indsub(MapObj2.get(test[0]).toString(), test[1], test[2], test[3], test[4]);
				MapObj2.put(test[5], string1);
			}
		}
	}

	/**
	 * 整理筛
	 * 
	 * @param test
	 */
	public void Clear(String[] test) {
		if (test[0].equals("") || test[0] == null) {
			System.out.println("Card-----工具包ArraySys:" + "逻辑第" + ArrNum + "句,前参数为空");
		} else if (test[1].equals("") || test[1] == null) {
			System.out.println("Card-----工具包ArraySys:" + "逻辑第" + ArrNum + "句,后参数为空");
		} else {
			MapObj1.put(test[0], MapObj2.get(test[1]));
		}
	}

	/**
	 * 获取操作参数
	 * 
	 * @param text 参数语句
	 * @return 详细参数数组
	 */
	public String[] TxtNo(String text) {
//		System.out.println(text);
		text = Indsub(text, ">", "0", "null", "0");
		text = Indsub(text, "null", "0", "</NO1>", "0");
		array2 = text.split("<@>");
		return array2;
	}

	/**
	 * 获取对应操作名
	 * 
	 * @param text
	 * @return
	 */
	public String Names(String text) {
		text = Indsub(text, "name=\"", "0", "null", "0");
		text = Indsub(text, "null", "0", "\"", "0");
		return text;
	}

	/**
	 * 遍历打印数组
	 * 
	 * @param array
	 */
	public void GetArraySys(String[] array) {
		System.out.println("Card-----工具包ArraySys:" + "逻辑第" + ArrNum + "句,打印所给数组");
		for (String ss : array) {
			System.out.println(ss);
		}
	}

	/**
	 * IO流读取文件方法
	 * 
	 * @param diiz   文件地址包括文件名加后缀
	 * @param tf     是否为逻辑语句(在读取后会打印文件的名称与版本号)
	 * @param concat 每行用所给字符进行分隔
	 * @return String 返回指定文件的数据,并整理为一行
	 */
	public String OutPut(String diiz, Boolean tf, String concat) {
		String txt1 = "";
		String txt2 = "";
		String no = "1";
		File file = new File(diiz);
		BufferedReader br = null;
		FileInputStream fis;
		if (file.isFile()) {
			try {
				fis = new FileInputStream(diiz);
				br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
				while ((no = br.readLine()) != null) {
					txt1 = no;
					txt2 = txt2.concat(concat + txt1.trim());
				}
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		} else {
			System.err.println("Card-----工具包OutPut:" + "逻辑第" + ArrNum + "句,指定路径文件不存在");
			return txt2 = "Card-----工具包OutPut:" + "指定路径文件不存在";
		}
		if (tf) {
			// 打印算法名称和型号
			string1 = Indsub(txt2, "<", "0", ">", "0");
			string2 = Indsub(string1, "name=\"", "0", "null", "0");
			string2 = Indsub(string2, "null", "0", "\"", "0");
			string1 = Indsub(string1, "class=\"", "0", "null", "0");
			string1 = Indsub(string1, "null", "0", "\"", "0");
			System.out.println("名称:" + string2);
			System.out.println("版本号:" + string1);
			MapObj2.put("名称", string2);
			MapObj2.put("版本号", string1);
		}
		return txt2;
	}

	/**
	 * 截取方法 String txt 文本数据 String SbeginIndex 字符串前参数 String SendIndex 字符串后参数
	 * 
	 * @param txt         文本数据
	 * @param SbeginIndex 字符串前参数
	 * @param SendIndex   字符串后参数
	 * @return 字符串 截取后参数 string1
	 */
	public String Indsub(String txt, String SbeginIndex, String Sbeginint, String SendIndex, String Sendint) {
		String retstr = "";
		int Sbeginints = Integer.parseInt(Sbeginint);
		int Sendints = Integer.parseInt(Sendint);

		if (txt.equals("") || txt == null || SbeginIndex.equals("") || SbeginIndex == null || SendIndex.equals("")
				|| SendIndex == null) {
			System.err.println("Card-----工具包Indsub:" + "逻辑第" + ArrNum + "句,前或后或数据参数为空");
		} else {

			if (SbeginIndex.equals("null")) {
				beginIndex = 0;
				endIndex = txt.indexOf(SendIndex);
				if (endIndex < 0) {
					System.err.println("Card-----工具包Indsub:" + "逻辑第" + ArrNum + "句,找不到后参数对应下标");
				} else {
					retstr = txt.substring(beginIndex, endIndex + Sendints);
				}
			} else if (SendIndex.equals("null")) {
				beginIndex = txt.indexOf(SbeginIndex);

				if (beginIndex < 0) {
					System.err.println("Card-----工具包Indsub:" + "逻辑第" + ArrNum + "句,找不到前参数对应下标");
				} else {
					retstr = txt.substring(beginIndex + SbeginIndex.length() + Sbeginints);
				}
			} else if (!SbeginIndex.equals("null") && !SendIndex.equals("null")) {
				beginIndex = txt.indexOf(SbeginIndex);
				endIndex = txt.indexOf(SendIndex);

				if (beginIndex < 0) {
					System.err.println("Card-----工具包Indsub:" + "逻辑第" + ArrNum + "句,找不到前参数对应下标");
				} else if (endIndex < 0) {
					System.err.println("Card-----工具包Indsub:" + "逻辑第" + ArrNum + "句,找不到后参数对应下标");
				} else if (beginIndex > endIndex) {
					System.err.println("Card-----工具包Indsub:" + "逻辑第" + ArrNum + "句,参数顺序有误(前参数大于后参数或读取到的数据有误)");
				} else {
					retstr = txt.substring(beginIndex + SbeginIndex.length() + Sbeginints, endIndex + Sendints);
				}
			}
		}
		return retstr;
	}

	/**
	 * 爬取方法
	 * 
	 * @param url
	 * @return
	 */
	public void Crawler(String[] list) {
		Document doc;

		try {
			String user_agent = "";
			if (list[2].equals("null")) {
				user_agent = header;
			} else if (list[2].equals("random")) {

			} else if (list[2].contains("user")) {

			}
			String url = list[0];
			if (list[1].contains("<!>")) {
				String[] array = list[1].split("<!>");
				for (int i = 0; i < array.length; i++) {
					url = url.replace(array[i], MapObj2.get(array[i]).toString());
				}
			}
			https: // 36kr.com/api/newsflash?b_id=177340&per_page=15614
//			https://36kr.com/api/newsflash?b_id=176781&per_page=20
			System.out.println(url);
			doc = Jsoup.connect(url).header("user-agent", user_agent).ignoreContentType(true).get();
			MapObj2.put(list[3], doc.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取编码格式 gb2312,UTF-16,UTF-8,Unicode,UTF-8
	 * 
	 * @param path
	 * @return
	 */
	public static String getCode(String path) {
		InputStream inputStream;
		String code = "";
		try {
			inputStream = new FileInputStream(path);

			byte[] head = new byte[3];
			inputStream.read(head);
			code = "gb2312"; // 或GBK
			if (head[0] == -1 && head[1] == -2)
				code = "UTF-16";
			else if (head[0] == -2 && head[1] == -1)
				code = "Unicode";
			else if (head[0] == -17 && head[1] == -69 && head[2] == -65)
				code = "UTF-8";
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(code);
		return code;
	}

}
