package com.zdr.sun.tools.Kr36;

/*
 * 粗提取方法:将只要内容从标签中分离
 * 导入爬取的文本
 * 返回拆分完的单篇新闻集合
 * */
import java.util.ArrayList;
import java.util.List;

public class roughFilter {
    public int front;// 前数字
    public int later;// 后数字
    public String textno1;// 存储字符串
    String[] zhi;

    public List saix(String information) {
	List<String> list = new ArrayList<String>();

	front = information.indexOf("items");
	later = information.lastIndexOf("</body>");
	textno1 = information.substring(front + 9, later - 6);
	textno1 = textno1.trim();
	// System.out.println(textno1);//筛选后的内容
	zhi = textno1.split("\\}\\,\\{");// 拆分为String数组
	for (int i = 0; i < zhi.length; i++) {
	    list.add(zhi[i]);// 转化为集合
	}
	return list;// 返回集合
    }
}
