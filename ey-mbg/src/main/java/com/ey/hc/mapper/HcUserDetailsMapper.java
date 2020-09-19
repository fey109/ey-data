package com.ey.hc.mapper;

import com.ey.hc.model.HcUserDetails;
import com.ey.hc.model.HcUserDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcUserDetailsMapper {
    long countByExample(HcUserDetailsExample example);

    int deleteByExample(HcUserDetailsExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(HcUserDetails record);

    int insertSelective(HcUserDetails record);

    List<HcUserDetails> selectByExample(HcUserDetailsExample example);

    HcUserDetails selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") HcUserDetails record, @Param("example") HcUserDetailsExample example);

    int updateByExample(@Param("record") HcUserDetails record, @Param("example") HcUserDetailsExample example);

    int updateByPrimaryKeySelective(HcUserDetails record);

    int updateByPrimaryKey(HcUserDetails record);
}