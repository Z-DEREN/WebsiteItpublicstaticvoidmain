package com.zdr.sun.pojo.IPpool;

public class Newips {
	// 唯一id号
	public String id;
	// ip号
	public String ip;
	// 端口号
	public String port;
	// 地区
	public String area;
	// 响应时间
	public int time;

	public Newips() {

	}

	public Newips(String ip, String port, String area, int time, String id) {
		super();
		this.ip = ip;
		this.port = port;
		this.area = area;
		this.time = time;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
