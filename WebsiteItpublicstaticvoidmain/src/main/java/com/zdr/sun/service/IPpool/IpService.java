package com.zdr.sun.service.IPpool;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdr.sun.pojo.IPpool.Newips;

public interface IpService {
	/**
	 * 添加测试国内IP表(没有相应时间的计算)
	 */
	public boolean addtetsChinaIP(Newips ip);

	/**
	 * 获取国内测试ip
	 * 
	 * @return
	 */
	public List<Newips> Listtestchips();

	/**
	 * 保存国内可用ip
	 * 
	 * @param ip
	 */
	public boolean addgoodChinaIP(Newips ip);

	/**
	 * 删除国内测试ip
	 * 
	 * @param ip
	 */
	public boolean deltestChinaIP(Newips ip);

	/**
	 * 删除国内测试未通过ip
	 * 
	 * @param ip
	 */
	public boolean delfromalChinaIP(Newips ip);

	/**
	 * 获取国内可用ip
	 * 
	 * @return
	 */
	public List<Newips> Listformalchips();

}
