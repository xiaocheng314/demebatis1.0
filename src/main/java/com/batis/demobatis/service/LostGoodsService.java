package com.batis.demobatis.service;

import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.entity.PickGoods;

import java.util.List;

/**
 * 失物招领的表(LostGoods)表服务接口
 *
 * @author lc
 * @since 2020-05-12 19:02:18
 */
public interface LostGoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param lostNumber 主键
     * @return 实例对象
     */
    LostGoods queryById(Integer lostNumber);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LostGoods> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param lostGoods 实例对象
     * @return 实例对象
     */
    LostGoods insert(LostGoods lostGoods);

    /**
     * 修改数据
     *
     * @param lostGoods 实例对象
     * @return 实例对象
     */
    int update(LostGoods lostGoods);

    /**
     * 通过主键删除数据
     *
     * @param lostNumber 主键
     * @return 是否成功
     */
    int deleteById(Integer lostNumber);

    /**
     * 查询所有失物招领
     * @return
     */
    List<LostGoods> selectLostAll();

    List<LostGoods> queryAllBy(int id);

    /**
     * 通过捡到物的名称来查询丢失物的信息
     * @param pickProduct
     * @return
     */
    List<LostGoods> selectAllByPickProduct(String pickProduct);

    /**
     * 通过openId来查询丢失物的信息
     * @param lostWxOpenId
     * @return
     */
    List<LostGoods> selectLostAllByOpenId(String lostWxOpenId);

    /**
     * 通过lostNumber来确认是否丢失物认领
     * @param lostNumber
     * @return
     */
    boolean getLostReturn(int lostNumber);

}