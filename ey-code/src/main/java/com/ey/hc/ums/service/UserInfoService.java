package com.ey.hc.ums.service;

import com.ey.hc.ums.entity.UserInfo;

import java.util.List;

/**
 * (UserInfo)表服务接口
 *
 * @author makejava
 * @since 2020-06-17 23:18:25
 */
public interface UserInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    UserInfo queryById(Long uId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    UserInfo insert(UserInfo userInfo);

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    UserInfo update(UserInfo userInfo);

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