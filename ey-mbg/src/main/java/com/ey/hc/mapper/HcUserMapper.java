package com.ey.hc.mapper;

import com.ey.hc.model.HcUser;
import com.ey.hc.model.HcUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcUserMapper {
    long countByExample(HcUserExample example);

    int deleteByExample(HcUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcUser record);

    int insertSelective(HcUser record);

    List<HcUser> selectByExample(HcUserExample example);

    HcUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcUser record, @Param("example") HcUserExample example);

    int updateByExample(@Param("record") HcUser record, @Param("example") HcUserExample example);

    int updateByPrimaryKeySelective(HcUser record);

    int updateByPrimaryKey(HcUser record);
}