package com.ey.hc.mapper;

import com.ey.hc.model.HcUmsLoginLog;
import com.ey.hc.model.HcUmsLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcUmsLoginLogMapper {
    long countByExample(HcUmsLoginLogExample example);

    int deleteByExample(HcUmsLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcUmsLoginLog record);

    int insertSelective(HcUmsLoginLog record);

    List<HcUmsLoginLog> selectByExample(HcUmsLoginLogExample example);

    HcUmsLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcUmsLoginLog record, @Param("example") HcUmsLoginLogExample example);

    int updateByExample(@Param("record") HcUmsLoginLog record, @Param("example") HcUmsLoginLogExample example);

    int updateByPrimaryKeySelective(HcUmsLoginLog record);

    int updateByPrimaryKey(HcUmsLoginLog record);
}