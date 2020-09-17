package com.ey.hc.mapper;

import com.ey.hc.model.HcRole;
import com.ey.hc.model.HcRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcRoleMapper {
    long countByExample(HcRoleExample example);

    int deleteByExample(HcRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcRole record);

    int insertSelective(HcRole record);

    List<HcRole> selectByExample(HcRoleExample example);

    HcRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcRole record, @Param("example") HcRoleExample example);

    int updateByExample(@Param("record") HcRole record, @Param("example") HcRoleExample example);

    int updateByPrimaryKeySelective(HcRole record);

    int updateByPrimaryKey(HcRole record);
}