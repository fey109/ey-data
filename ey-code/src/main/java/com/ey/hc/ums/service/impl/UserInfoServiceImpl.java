package com.ey.hc.ums.service.impl;

import com.ey.hc.ums.dao.UserInfoDao;
import com.ey.hc.ums.entity.UserInfo;
import com.ey.hc.ums.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-06-17 23:18:26
 */
@Service(value = "userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;


    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public UserInfo queryById(Long uId) {
        return this.userInfoDao.queryById(uId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserInfo> queryAllByLimit(int offset, int limit) {
        return this.userInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    @Override
    public UserInfo insert(UserInfo userInfo) {
        this.userInfoDao.insert(userInfo);
        return userInfo;
    }

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    @Override
    public UserInfo update(UserInfo userInfo) {
        this.userInfoDao.update(userInfo);
        return this.queryById(userInfo.getUId());
    }

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long uId) {
        return this.userInfoDao.deleteById(uId) > 0;
    }

    @Override
    public String findByName(String username,String password) {
       if (username != null){
           UserInfo userInfo=new UserInfo();
           userInfo.setUsername(username);
           userInfo.setPassword(password);
           UserInfo user=userInfoDao.findByName(userInfo);
           String token= JwtUtils.createToken(user);
           return token;
       }else {

            return  null;
       }

    }
}