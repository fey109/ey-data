package com.ey.hc.mapper;

import com.ey.hc.model.HcPermission;
import com.ey.hc.model.HcUser;

import java.util.List;

public interface HcShiroUserRoleMapper {


    String getRole(String username);


    List<HcPermission> getPermission(String  name);


    HcUser selectUserOne(String username);








}
