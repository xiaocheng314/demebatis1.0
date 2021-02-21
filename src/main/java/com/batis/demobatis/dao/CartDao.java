package com.batis.demobatis.dao;

import com.batis.demobatis.entity.CartImg;
import org.springframework.stereotype.Repository;

/**
 *(cartImg表)访问接口
 *
 * @return
 * @author lc
 * @createTime 2020/6/28 8:32
 *
 */
@Repository
public interface CartDao {

    int insert(CartImg cartImg);

    CartImg queryById(Integer number);

    int delete(Integer number);
}
