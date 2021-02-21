package com.batis.demobatis.service.impl;

import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.dao.LostGoodsDao;
import com.batis.demobatis.entity.PickGoods;
import com.batis.demobatis.service.LostGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 失物招领的表(LostGoods)表服务实现类
 *
 * @author lc
 * @since 2020-05-12 19:02:18
 */
@Service
public class LostGoodsServiceImpl implements LostGoodsService {
    @Autowired
    private LostGoodsDao lostGoodsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param lostNumber 主键
     * @return 实例对象
     */
    @Override
    public LostGoods queryById(Integer lostNumber) {
        return lostGoodsDao.queryById(lostNumber);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<LostGoods> queryAllByLimit(int offset, int limit) {
        return this.lostGoodsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param lostGoods 实例对象
     * @return 实例对象
     */
    @Override
    public LostGoods insert(LostGoods lostGoods) {
        this.lostGoodsDao.insert(lostGoods);
        return lostGoods;
    }

    /**
     * 修改数据
     *
     * @param lostGoods 实例对象
     * @return 实例对象
     */
    @Override
    public int update(LostGoods lostGoods) {
        return lostGoodsDao.update(lostGoods);
    }

    /**
     * 通过主键删除数据
     *
     * @param lostNumber 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer lostNumber) {
        int res=lostGoodsDao.deleteById(lostNumber);
        return res;
    }

    @Override
    public List<LostGoods> selectLostAll() {
        return lostGoodsDao.queryAll();
    }

    @Override
    public List<LostGoods> queryAllBy(int id) {
        return lostGoodsDao.queryAllBy(id);
    }

    @Override
    public List<LostGoods> selectAllByPickProduct(String pickProduct) {
        return lostGoodsDao.queryAllByPickProduct(pickProduct);
    }

    @Override
    public List<LostGoods> selectLostAllByOpenId(String lostWxOpenId) {
        return lostGoodsDao.queryLostAllByOpenId(lostWxOpenId);
    }

    @Override
    public boolean getLostReturn(int lostNumber) {
        int updateLost = lostGoodsDao.updateLostReturn(lostNumber);
        boolean isLostReturn = false;
        if(updateLost > 0) {
            isLostReturn = true;
        }else {
            isLostReturn = false;
        }
        return isLostReturn;

    }


}