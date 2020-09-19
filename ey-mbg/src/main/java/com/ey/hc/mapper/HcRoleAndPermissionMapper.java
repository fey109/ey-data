package com.ey.hc.mapper;

import com.ey.hc.model.HcRoleAndPermission;
import com.ey.hc.model.HcRoleAndPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcRoleAndPermissionMapper {
    long countByExample(HcRoleAndPermissionExample example);

    int deleteByExample(HcRoleAndPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcRoleAndPermission record);

    int insertSelective(HcRoleAndPermission record);

    List<HcRoleAndPermission> selectByExample(HcRoleAndPermissionExample example);

    HcRoleAndPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcRoleAndPermission record, @Param("example") HcRoleAndPermissionExample example);

    int updateByExample(@Param("record") HcRoleAndPermission record, @Param("example") HcRoleAndPermissionExample example);

    int updateByPrimaryKeySelective(HcRoleAndPermission record);

    int updateByPrimaryKey(HcRoleAndPermission record);
}