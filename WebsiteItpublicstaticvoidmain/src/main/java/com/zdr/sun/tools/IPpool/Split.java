package com.zdr.sun.tools.IPpool;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.zdr.sun.pojo.IPpool.Newips;
import com.zdr.sun.service.IPpool.IpService;
import com.zdr.sun.tools.ApplicationContextHelper.ApplicationContextHelper;

@Controller
public class Split {

	IpService IpSer = ApplicationContextHelper.getBean(IpService.class);

	Newips Newips = new Newips();

	/**
	 * 保存国内测试ip
	 * 
	 * @param ip
	 */
	public void addtetsChinaIP(Newips ip) {
		IpSer.addtetsChinaIP(ip);
	}

	/**
	 * 保存国内可用ip
	 * 
	 * @param ip
	 */
	public void addgoodChinaIP(Newips ip) {
		IpSer.addgoodChinaIP(ip);
	}

	/**
	 * 删除国内测试ip
	 * 
	 * @param ip
	 */
	public void deltestChinaIP(Newips ip) {
		IpSer.deltestChinaIP(ip);
	}

	/**
	 * 删除国内测试未通过ip
	 * 
	 * @param ip
	 */
	public void delfromalChinaIP(Newips ip) {
		IpSer.delfromalChinaIP(ip);
	}
	
	
	
	/**
	 * 获取国内测试ip
	 * 
	 * @param text
	 * @return
	 */
	public List<Newips> Listtestchips() {
		List<Newips> lsit = IpSer.Listtestchips();
		return lsit;
	}

	/**
	 * 获取国内可用ip
	 * 
	 * @param text
	 * @return
	 */
	public List<Newips> Listformalchips() {
		List<Newips> lsit = IpSer.Listformalchips();
		return lsit;
	}
}
