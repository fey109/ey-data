package com.ey.hc.mapper;

import com.ey.hc.model.HcRolePermission;
import com.ey.hc.model.HcRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcRolePermissionMapper {
    long countByExample(HcRolePermissionExample example);

    int deleteByExample(HcRolePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcRolePermission record);

    int insertSelective(HcRolePermission record);

    List<HcRolePermission> selectByExample(HcRolePermissionExample example);

    HcRolePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcRolePermission record, @Param("example") HcRolePermissionExample example);

    int updateByExample(@Param("record") HcRolePermission record, @Param("example") HcRolePermissionExample example);

    int updateByPrimaryKeySelective(HcRolePermission record);

    int updateByPrimaryKey(HcRolePermission record);
}