package com.batis.demobatis.service;

import com.batis.demobatis.entity.CartImg;
import org.springframework.stereotype.Repository;

/**
 *(cartImg表)访问接口
 *
 * @return
 * @author lc
 * @createTime 2020/6/28 8:43
 *
 */
@Repository
public interface CartService {
    int insert(CartImg cartImg);

    CartImg queryById(Integer number);

    int delete(Integer number);
}
