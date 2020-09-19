package com.ey.hc.ums.service;

import com.ey.hc.model.HcUser;

import java.util.List;

/**
 * (UserInfo)表服务接口
 *
 * @author makejava
 * @since 2020-06-17 23:18:25
 */
public interface HcUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    HcUser queryById(Long uId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HcUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param hcUser 实例对象
     * @return 实例对象
     */
    HcUser insert(HcUser hcUser);

    /**
     * 修改数据
     *
     * @param hcUser 实例对象
     * @return 实例对象
     */
    HcUser update(HcUser hcUser);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    boolean deleteById(Long uId);


    /**
     * login
     * @param username
     * @param password
     * @return
     */
    String findByName(String username,String password);

}