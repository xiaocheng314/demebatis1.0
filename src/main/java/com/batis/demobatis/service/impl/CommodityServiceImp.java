package com.batis.demobatis.service.impl;

import com.batis.demobatis.dao.CommodityDao;
import com.batis.demobatis.entity.Commodity;
import com.batis.demobatis.service.CommodityService;
import com.batis.demobatis.vo.CommodityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年06月28日 8:45
 * @version: 1.0
 */
@Service
public class CommodityServiceImp implements CommodityService {
    @Autowired
    CommodityDao commodityDao;

    @Override
    public Commodity insert(Commodity commodity) {
        this.commodityDao.insert(commodity);
        return commodity;
    }
    @Override
    public int delete(Integer number) {
        int result = commodityDao.delete(number);
        return result;
    }

    @Override
    public List<CommodityVo> commoditySelectAll() {
        List<CommodityVo> commodityVoList = commodityDao.commoditySelectAll();
        return commodityVoList;
    }

    @Override
    public Commodity queryById(Commodity commodity) {
        return commodityDao.queryById(commodity);
    }


    @Override
    public int update(Commodity commodity) {
        int result = commodityDao.update(commodity);
        return result;
    }
}
