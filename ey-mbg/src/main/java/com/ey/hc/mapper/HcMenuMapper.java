package com.ey.hc.mapper;

import com.ey.hc.model.HcMenu;
import com.ey.hc.model.HcMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcMenuMapper {
    long countByExample(HcMenuExample example);

    int deleteByExample(HcMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcMenu record);

    int insertSelective(HcMenu record);

    List<HcMenu> selectByExample(HcMenuExample example);

    HcMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcMenu record, @Param("example") HcMenuExample example);

    int updateByExample(@Param("record") HcMenu record, @Param("example") HcMenuExample example);

    int updateByPrimaryKeySelective(HcMenu record);

    int updateByPrimaryKey(HcMenu record);
}