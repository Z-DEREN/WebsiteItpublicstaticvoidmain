/**
 * 
 */
package com.zdr.sun.service.cangku;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdr.sun.pojo.cangku.Cangkupan;

/**
 * 
 * <p>
 * Title: CangkuService
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
public interface CangkuService {
	/**
	 * 获取表内全部信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Cangkupan> selectpan() throws Exception;

	/**
	 * 删除无用项
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean delelaji() throws Exception;

	/**
	 * 根据类型获取最小的数据
	 * 
	 * @param type_num
	 * @return
	 * @throws Exception
	 */
	public List<Cangkupan> seleminid(String type_num) ;

	/**
	 * 删除id最小的数据
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean deleminid() throws Exception;

	/**
	 * 逻辑删除,指定id条目
	 * 
	 * @param newid
	 * @return
	 * @throws Exception
	 */
	public boolean updateminid(String newid) throws Exception;

	/**
	 * 获取所有类型
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> Alltype() ;

}
