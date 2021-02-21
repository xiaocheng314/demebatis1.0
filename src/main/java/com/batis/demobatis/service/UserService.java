package com.batis.demobatis.service;

import com.batis.demobatis.entity.User;
import com.batis.demobatis.util.Result;

import java.util.List;

/**
 * 用户表(User)表服务接口
 *
 * @author lc
 * @since 2020-05-12 19:00:32
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param uuId 主键
     * @return 实例对象
     */
    User queryById(String uuId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 查询所有数据
     *
     * @return
     */
    List<User> selectAll();

    /**
     * true
     *
     * @param uuid
     * @param openid
     * @return
     */
    User insert(String uuid,String openid);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param openid 主键
     * @return 是否成功
     */
    int deleteById(String openid);

}