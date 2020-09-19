package com.ey.hc.mapper;

import com.ey.hc.model.HcUserAndDetails;
import com.ey.hc.model.HcUserAndDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcUserAndDetailsMapper {
    long countByExample(HcUserAndDetailsExample example);

    int deleteByExample(HcUserAndDetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcUserAndDetails record);

    int insertSelective(HcUserAndDetails record);

    List<HcUserAndDetails> selectByExample(HcUserAndDetailsExample example);

    HcUserAndDetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcUserAndDetails record, @Param("example") HcUserAndDetailsExample example);

    int updateByExample(@Param("record") HcUserAndDetails record, @Param("example") HcUserAndDetailsExample example);

    int updateByPrimaryKeySelective(HcUserAndDetails record);

    int updateByPrimaryKey(HcUserAndDetails record);
}