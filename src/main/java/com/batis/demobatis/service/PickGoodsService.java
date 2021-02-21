package com.batis.demobatis.service;

import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.entity.PickGoods;
import java.util.List;

/**
 * 寻找物品的表(PickGoods)表服务接口
 *
 * @author lc
 * @since 2020-05-12 19:01:44
 */
public interface PickGoodsService {

    /**
     * 通过ID查询单条数据
     *
     * @param pickNumber 主键
     * @return 实例对象
     */
    PickGoods queryById(Integer pickNumber);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PickGoods> queryAllByLimit(int offset, int limit);

    /**
     * 查询所有寻物数据
     * @return
     */
    List<PickGoods> selectAllPick();

    /**
     * 新增数据
     *
     * @param pickGoods 实例对象
     * @return 实例对象
     */
    PickGoods insert(PickGoods pickGoods);

    /**
     * 修改数据
     *
     * @param pickGoods 实例对象
     * @return 实例对象
     */
    int update(PickGoods pickGoods);

    /**
     * 通过主键删除数据
     *
     * @param pickNumber 主键
     * @return 是否成功
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
    List<PickGoods> selectAllByLostProduct(String lostProduct);

    /**
     * 通过openId来查询捡到物的信息
     * @param pickWxOpenId
     * @return
     */
    List<PickGoods> selectPickAllByOpenId(String pickWxOpenId);

}