package com.zdr.sun.tools.IPpool;

public class AcquireIp {
	IpPool IpPool;

	/**
	 * 获取国内ip
	 */
	public void ChinaIPs() {
		IpPool = new IpPool();
		System.out.println("进入主方法,获取国内ip");
		IpPool.ChinaIPs();
		System.out.println("主结束");
	}

	/**
	 * 测试国内ip
	 */
	public void testchinaips() {
		IpPool = new IpPool();
		System.out.println("进入主方法,测试国内ip");
		IpPool.testchinaips();
		System.out.println("主结束");
	}

	/**
	 * 测试国内可用ip
	 */
	public void fromalchinaips() {
		IpPool = new IpPool();
		System.out.println("进入主方法,测试国内可用ip");
		IpPool.fromalchinaips();
		System.out.println("主结束");
	}

}
