package com.batis.demobatis.service.impl;

import com.batis.demobatis.entity.Express;
import com.batis.demobatis.dao.ExpressDao;
import com.batis.demobatis.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Express)表服务实现类
 *
 * @author lc
 * @since 2020-05-12 19:03:22
 */
@Service
public class ExpressServiceImpl implements ExpressService {
    @Autowired
    private ExpressDao expressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param stuId
     * @return 实例对象
     */

    @Override
    public Express queryById(Integer stuId) {
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Express> queryAllByLimit(int offset, int limit) {
        return this.expressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param express 实例对象
     * @return 实例对象
     */
    @Override
    public Express insert(Express express) {
        this.expressDao.insert(express);
        return express;
    }

    /**
     * 修改数据
     *
     * @param express 实例对象
     * @return 实例对象
     */
    @Override
    public Express update(Express express) {
        this.expressDao.update(express);
        return this.queryById(express.getExpressId());
    }


    /**
     * 通过主键删除数据
     *
     * @param stuId
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer stuId) {
        return this.expressDao.deleteById() > 0;
    }
}