package com.ey.hc.mapper;

import com.ey.hc.model.HcUserRole;
import com.ey.hc.model.HcUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcUserRoleMapper {
    long countByExample(HcUserRoleExample example);

    int deleteByExample(HcUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcUserRole record);

    int insertSelective(HcUserRole record);

    List<HcUserRole> selectByExample(HcUserRoleExample example);

    HcUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcUserRole record, @Param("example") HcUserRoleExample example);

    int updateByExample(@Param("record") HcUserRole record, @Param("example") HcUserRoleExample example);

    int updateByPrimaryKeySelective(HcUserRole record);

    int updateByPrimaryKey(HcUserRole record);
}