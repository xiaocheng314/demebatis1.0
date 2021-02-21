package com.batis.demobatis.service;

import com.batis.demobatis.entity.Express;
import java.util.List;

/**
 * (Express)表服务接口
 *
 * @author lc
 * @since 2020-05-12 19:03:22
 */
public interface ExpressService {

    /**
     * 通过ID查询单条数据
     *
     * @param  stuId
     * @return 实例对象
     */
    Express queryById(Integer stuId );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Express> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param express 实例对象
     * @return 实例对象
     */
    Express insert(Express express);

    /**
     * 修改数据
     *
     * @param express 实例对象
     * @return 实例对象
     */
    Express update(Express express);

    /**
     * 通过主键删除数据
     *
     * @param  stuId
     * @return 是否成功
     */
    boolean deleteById(Integer stuId );
}