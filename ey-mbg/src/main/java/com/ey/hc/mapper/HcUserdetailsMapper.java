package com.ey.hc.mapper;

import com.ey.hc.model.HcUserdetails;
import com.ey.hc.model.HcUserDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcUserDetailsMapper {
    long countByExample(HcUserDetailsExample example);

    int deleteByExample(HcUserDetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcUserdetails record);

    int insertSelective(HcUserdetails record);

    List<HcUserdetails> selectByExample(HcUserDetailsExample example);

    HcUserdetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcUserdetails record, @Param("example") HcUserDetailsExample example);

    int updateByExample(@Param("record") HcUserdetails record, @Param("example") HcUserDetailsExample example);

    int updateByPrimaryKeySelective(HcUserdetails record);

    int updateByPrimaryKey(HcUserdetails record);
}