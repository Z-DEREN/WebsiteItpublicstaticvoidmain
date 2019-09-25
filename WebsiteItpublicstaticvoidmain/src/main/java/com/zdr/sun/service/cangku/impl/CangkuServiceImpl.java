/**
 * 
 */
package com.zdr.sun.service.cangku.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zdr.sun.pojo.cangku.Cangkupan;
import com.zdr.sun.service.cangku.CangkuService;
import com.zdr.sun.dao.cangku.CangkuMapper;

/**
 * 
 * <p>
 * Title: CangkuServiceImpl
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * @author shenlan
 * 
 * @date 2018年12月12日
 * 
 */
@Service
public class CangkuServiceImpl implements CangkuService {
	@Resource
	private CangkuMapper CangkuMapper;

	public List<Cangkupan> selectpan() throws Exception {
		// TODO Auto-generated method stub
		List<Cangkupan> list = new ArrayList<Cangkupan>();
		list = CangkuMapper.selectpan();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: delelaji</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see com.css.cangkus.service.cangku.CangkuService#delelaji()
	 * 
	 */
	public boolean delelaji() throws Exception {
		// TODO Auto-generated method stub
		boolean tf = false;
		if (CangkuMapper.delelaji() > 0) {
			tf = true;
		}
		return tf;
	}

	/*
	 * 根据类型获取最小的数据 (non-Javadoc)
	 * 
	 * <p>Title: seleminid</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see com.css.cangkus.service.cangku.CangkuService#seleminid()
	 * 
	 */
	public List<Cangkupan> seleminid(String type_num) {
		// TODO Auto-generated method stub
		List<Cangkupan> list = new ArrayList<Cangkupan>();
		try {
			list = CangkuMapper.seleminid(type_num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * <p>Title: deleminid</p>
	 * 
	 * <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see com.css.cangkus.service.cangku.CangkuService#deleminid()
	 * 
	 */
	public boolean deleminid() throws Exception {
		// TODO Auto-generated method stub
		boolean tf = false;
		if (CangkuMapper.deleminid() > 0) {
			tf = true;
		}
		return tf;
	}

	/**
	 * 逻辑删除,对目标进行标记
	 */
	public boolean updateminid(String num) throws Exception {
		// TODO Auto-generated method stub
		boolean tf = false;
		CangkuMapper.updateminid(num);
		return tf;
	}

	/**
	 * 获取所有类型
	 */
	public List<String> Alltype() {
		// TODO Auto-generated method stub
		return CangkuMapper.Alltype();
	}
	
	
	
}
