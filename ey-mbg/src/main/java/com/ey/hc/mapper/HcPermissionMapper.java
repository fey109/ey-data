package com.ey.hc.mapper;

import com.ey.hc.model.HcPermission;
import com.ey.hc.model.HcPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HcPermissionMapper {
    long countByExample(HcPermissionExample example);

    int deleteByExample(HcPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HcPermission record);

    int insertSelective(HcPermission record);

    List<HcPermission> selectByExample(HcPermissionExample example);

    HcPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HcPermission record, @Param("example") HcPermissionExample example);

    int updateByExample(@Param("record") HcPermission record, @Param("example") HcPermissionExample example);

    int updateByPrimaryKeySelective(HcPermission record);

    int updateByPrimaryKey(HcPermission record);
}