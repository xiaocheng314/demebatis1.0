package com.batis.demobatis.dao;

import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.entity.PickGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 失物招领的表(LostGoods)表数据库访问层
 *
 * @author lc
 * @since 2020-05-12 19:02:18
 */
@Repository
public interface LostGoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param lostNumber 主键
     * @return 实例对象
     */
    LostGoods queryById(Integer lostNumber);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LostGoods> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<LostGoods> queryAll();

    /**
     * 新增数据
     *
     * @param lostGoods 实例对象
     * @return 影响行数
     */
    int insert(LostGoods lostGoods);

    /**
     * 修改数据
     *
     * @param lostGoods 实例对象
     * @return 影响行数
     */
    int update(LostGoods lostGoods);

    /**
     * 通过主键删除数据
     *
     * @param lostNumber 主键
     * @return 影响行数
     */
    int deleteById(Integer lostNumber);

    List<LostGoods> queryAllBy(int id);

    /**
     * 通过丢失物的名称来查询捡到物的信息
     * @param pickProduct
     * @return
     */
    List<LostGoods> queryAllByPickProduct(String pickProduct);

    /**
     * 通过openId来查询丢失物的信息
     * @param lostWxOpenId
     * @return
     */
    List<LostGoods> queryLostAllByOpenId(String lostWxOpenId);

    /**
     * 通过lostNumber来确认是否丢失物认领
     * @param lostNumber
     * @return
     */
    int updateLostReturn(int lostNumber);

}