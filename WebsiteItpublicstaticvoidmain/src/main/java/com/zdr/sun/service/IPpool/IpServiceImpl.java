package com.zdr.sun.service.IPpool;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdr.sun.pojo.IPpool.Newips;
import com.zdr.sun.dao.IPpool.IpDaoMapper;

@Service
public class IpServiceImpl implements IpService {
	@Resource
	private IpDaoMapper IpDaoMapper;

	/**
	 * 添加测试国内IP表(没有相应时间的计算)
	 */
	@Override
	public boolean addtetsChinaIP(Newips ip) {
		// TODO Auto-generated method stub
		boolean tf = false;
		if (IpDaoMapper.addtetsChinaIP(ip) > 0) {
			tf = true;
		}
		return tf;
	}

	/**
	 * 获取数据库所有国内测试ip
	 */
	@Override
	public List<Newips> Listtestchips() {
		// TODO Auto-generated method stub
		return IpDaoMapper.Listtestchips();
	}

	/**
	 * 保存国内可用ip
	 * 
	 * @param ip
	 */
	@Override
	public boolean addgoodChinaIP(Newips ip) {
		// TODO Auto-generated method stub
		boolean tf = false;
		if (IpDaoMapper.addgoodChinaIP(ip) > 0) {
			tf = true;
		}
		return tf;
	}

	/**
	 * 删除国内测试ip
	 * 
	 * @param ip
	 */
	@Override
	public boolean deltestChinaIP(Newips ip) {
		// TODO Auto-generated method stub
		boolean tf = false;
		if (IpDaoMapper.deltestChinaIP(ip) > 0) {
			tf = true;
		}
		return tf;
	}

	/**
	 * 删除国内测试未通过ip
	 * 
	 * @param ip
	 */
	@Override
	public boolean delfromalChinaIP(Newips ip) {
		// TODO Auto-generated method stub
		boolean tf = false;
		if (IpDaoMapper.delfromalChinaIP(ip) > 0) {
			tf = true;
		}
		return tf;
	}

	/**
	 * 获取国内可用ip
	 */
	@Override
	public List<Newips> Listformalchips() {
		// TODO Auto-generated method stub
		return IpDaoMapper.Listformalchips();
	}

}
