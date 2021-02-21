package com.batis.demobatis.service.impl;

import com.batis.demobatis.dao.CartDao;
import com.batis.demobatis.entity.CartImg;
import com.batis.demobatis.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年06月28日 8:45
 * @version: 1.0
 */
@Service
public class CartServiceImp implements CartService {

    @Autowired
    CartDao cartDao;
    @Override
    public int insert(CartImg cartImg) {
        int result = cartDao.insert(cartImg);
        return result;
    }

    @Override
    public CartImg queryById(Integer number) {
        return cartDao.queryById(number);
    }

    @Override
    public int delete(Integer number) {
        int result = cartDao.delete(number);
        return result;
    }
}
