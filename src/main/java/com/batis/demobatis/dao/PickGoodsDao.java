package com.batis.demobatis.dao;

import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.entity.PickGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 寻找物品的表(PickGoods)表数据库访问层
 *
 * @author lc
 * @since 2020-05-12 19:01:44
 */
@Repository
public interface PickGoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pickNumber 主键
     * @return 实例对象
     */
    PickGoods queryById(Integer pickNumber);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PickGoods> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param
     * @return 对象列表
     */
    List<PickGoods> queryAll();

    /**
     * 新增数据
     *
     * @param pickGoods 实例对象
     * @return 影响行数
     */
    int insert(PickGoods pickGoods);

    /**
     * 修改数据
     *
     * @param pickGoods 实例对象
     * @return 影响行数
     */
    int update(PickGoods pickGoods);

    /**
     * 通过主键删除数据
     *
     * @param pickNumber 主键
     * @return 影响行数
     */
    int deleteById(Integer pickNumber);

    /**
     * 查询个人全部数据
     * @return
     */
    List<PickGoods> pickQueryByAll();

    List<PickGoods> queryAllBy(int id);

    /**
     * 通过丢失物的名称来查询捡到物的信息
     * @param lostProduct
     * @return
     */
    List<PickGoods> queryAllByLostProduct(String lostProduct);

    /**
     * 通过openId来查询捡到物的信息
     * @param pickWxOpenId
     * @return
     */
    List<PickGoods> queryPickAllByOpenId(String pickWxOpenId);
}