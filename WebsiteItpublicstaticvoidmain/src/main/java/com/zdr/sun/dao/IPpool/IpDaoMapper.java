package com.zdr.sun.dao.IPpool;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zdr.sun.pojo.IPpool.Newips;

@Repository // 连接数据库注解
public interface IpDaoMapper {
	/**
	 * 添加测试国内IP表(没有相应时间的计算)
	 */
	public int addtetsChinaIP(Newips ip);

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
	public int addgoodChinaIP(Newips ip);

	/**
	 * 删除国内测试ip
	 * 
	 * @param ip
	 */
	public int deltestChinaIP(Newips ip);

	/**
	 * 删除国内测试未通过ip
	 * 
	 * @param ip
	 */
	public int delfromalChinaIP(Newips ip);

	/**
	 * 获取国内可用ip
	 * 
	 * @return
	 */
	public List<Newips> Listformalchips();

}
