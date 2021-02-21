package com.batis.demobatis.dao;

import com.batis.demobatis.entity.Commodity;
import com.batis.demobatis.vo.CommodityVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *(访问商品表)的接口
 *
 * @return
 * @author lc
 * @createTime 2020/6/28 8:38
 *
 */
@Repository
public interface CommodityDao {
    int insert(Commodity commodity);

    int delete(Integer number);

    List<CommodityVo> commoditySelectAll();

    Commodity queryById(Commodity commodity);

    int update(Commodity commodity);
}
