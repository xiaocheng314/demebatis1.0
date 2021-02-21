package com.batis.demobatis.service.impl;

import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.batis.demobatis.dao.UserDao;
import com.batis.demobatis.entity.User;
import com.batis.demobatis.service.UserService;
import com.batis.demobatis.util.Result;
import com.batis.demobatis.util.ResultEnum;
import com.batis.demobatis.util.WxChatResolveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户表(User)表服务实现类
 *
 * @author lc
 * @since 2020-05-12 22:17:04
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private WxChatResolveUtil wxChatResolveUtil;

    /**
     * 通过ID查询单条数据
     *
     * @param uuId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(String uuId) {
        return this.userDao.queryById(uuId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<User> selectAll() {
        List<User> userList = userDao.selectAll();
        return userList;
    }

    /**
     * 新增数据，返回uuid作为登录查询的登录态
     *
     * @param openId
     * @param uuId
     * @return 实例对象
     */
    @Override
    public User insert(String uuId, String openId) {
        User user = userDao.queryById(openId);
        if (user != null) {
            return user;
        }
        return this.userDao.insert(uuId, openId);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int update(User user) {
        if (userDao.queryById(user.getUuId()) == null) {
            return 0;
        }
        return userDao.update(user);
    }

    /**
     * 通过主键删除数据
     *
     * @param stuId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String stuId) {
        int result = userDao.deleteById(stuId);
        return result;
    }
}