package com.batis.demobatis.service.impl;

import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.entity.PickGoods;
import com.batis.demobatis.dao.PickGoodsDao;
import com.batis.demobatis.service.PickGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 寻找物品的表(PickGoods)表服务实现类
 *
 * @author lc
 * @since 2020-05-12 19:01:44
 */
@Service
public class PickGoodsServiceImpl implements PickGoodsService {
    @Autowired
    private PickGoodsDao pickGoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pickNumber 主键
     * @return 实例对象
     */
    @Override
    public PickGoods queryById(Integer pickNumber) {
        return pickGoodsDao.queryById(pickNumber);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PickGoods> queryAllByLimit(int offset, int limit) {
        return this.pickGoodsDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<PickGoods> selectAllPick() {
        return pickGoodsDao.queryAll();
    }
    /**
     * 新增数据
     *
     * @param pickGoods 实例对象
     * @return 实例对象
     */
    @Override
    public PickGoods insert(PickGoods pickGoods) {
        this.pickGoodsDao.insert(pickGoods);
        return pickGoods;
    }

    /**
     * 修改数据
     *
     * @param pickGoods 实例对象
     * @return 实例对象
     */
    @Override
    public int update(PickGoods pickGoods) {
        return pickGoodsDao.update(pickGoods);
    }
    /**
     * 通过主键删除数据
     *
     * @param pickNumber 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer pickNumber) {
        int res = pickGoodsDao.deleteById(pickNumber);
        return res;
    }

    @Override
    public List<PickGoods> pickQueryByAll() {
        return pickGoodsDao.pickQueryByAll();
    }

    @Override
    public List<PickGoods> queryAllBy(int id) {
        return pickGoodsDao.queryAllBy(id);
    }

    @Override
    public List<PickGoods> selectAllByLostProduct(String lostProduct) {
        return pickGoodsDao.queryAllByLostProduct(lostProduct);
    }

    @Override
    public List<PickGoods> selectPickAllByOpenId(String pickWxOpenId) {
        return pickGoodsDao.queryPickAllByOpenId(pickWxOpenId);
    }


}