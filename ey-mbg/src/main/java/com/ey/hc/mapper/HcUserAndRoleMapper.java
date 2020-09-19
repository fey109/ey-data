package com.ey.hc.mapper;

import com.ey.hc.model.HcUserAndRole;
import com.ey.hc.model.HcUserAndRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcUserAndRoleMapper {
    long countByExample(HcUserAndRoleExample example);

    int deleteByExample(HcUserAndRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcUserAndRole record);

    int insertSelective(HcUserAndRole record);

    List<HcUserAndRole> selectByExample(HcUserAndRoleExample example);

    HcUserAndRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcUserAndRole record, @Param("example") HcUserAndRoleExample example);

    int updateByExample(@Param("record") HcUserAndRole record, @Param("example") HcUserAndRoleExample example);

    int updateByPrimaryKeySelective(HcUserAndRole record);

    int updateByPrimaryKey(HcUserAndRole record);
}