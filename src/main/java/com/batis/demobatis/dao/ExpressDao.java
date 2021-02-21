package com.batis.demobatis.dao;

import com.batis.demobatis.entity.Express;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Express)表数据库访问层
 *
 * @author lc
 * @since 2020-05-12 19:03:22
 */
@Repository
public interface ExpressDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    Express queryById( );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Express> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param express 实例对象
     * @return 对象列表
     */
    List<Express> queryAll(Express express);

    /**
     * 新增数据
     *
     * @param express 实例对象
     * @return 影响行数
     */
    int insert(Express express);

    /**
     * 修改数据
     *
     * @param express 实例对象
     * @return 影响行数
     */
    int update(Express express);

    /**
     * 通过主键删除数据
     *
     * @return 影响行数
     */
    int deleteById( );

}