package com.ey.hc.ums.service.impl;

import com.ey.hc.model.HcUser;
import com.ey.hc.ums.service.HcUserService;

import java.util.List;

public class HcUserServiceImpl implements HcUserService{

    @Override
    public HcUser queryById(Long uId) {
        return null;
    }

    @Override
    public List<HcUser> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public HcUser insert(HcUser hcUser) {
        return null;
    }

    @Override
    public HcUser update(HcUser hcUser) {
        return null;
    }

    @Override
    public boolean deleteById(Long uId) {
        return false;
    }

    @Override
    public String findByName(String username, String password) {
        return null;
    }
}