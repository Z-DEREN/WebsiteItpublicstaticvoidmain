/**
 * 
 */
package com.zdr.sun.dao.cangku;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zdr.sun.pojo.cangku.Cangkupan;

/**
 * 
 * <p>
 * Title: CangkuMapper
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
@Repository // 连接数据库注解
public interface CangkuMapper {

    // 获取所有pan
    public List<Cangkupan> selectpan() throws Exception;

    // 删除无用项
    public int delelaji() throws Exception;

    // 根据类型获取最小的数据
    public List<Cangkupan> seleminid(@Param("type")String type_num) throws Exception;

    // 删除id最小的数据
    public int deleminid() throws Exception;

    // 逻辑删除,更改id最小数据
    public int updateminid(@Param("newid") String newid) throws Exception;
    
    // 获取所有类型
    public List<String> Alltype() ;
}