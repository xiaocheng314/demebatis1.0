//package com.batis.demobatis.util;
//
//import com.batis.demobatis.entity.User;
//import com.batis.demobatis.service.impl.UserServiceImpl;
//import com.batis.demobatis.vo.GoodsVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//
///**
// * @projectName: demebatis1.0
// * @author: Administrator
// * @date: 2020年06月22日 15:19
// * @version: 1.0
// */
//@Component
//public class UpdateGoods {
//
//    @Autowired
//    private UserServiceImpl userService;
//    public static UpdateGoods updateGoods;
//
//    @PostConstruct
//    public void init() {
//        updateGoods = this;
//        updateGoods.userService = this.userService;
//    }
//
//    public GoodsVo update(String openid) {
//        User user = updateGoods.userService.queryById(openid);
//        GoodsVo goodsVo = new GoodsVo();
//        goodsVo.setGrade(user.getStuGrade());
//        goodsVo.setCollege(user.getStuCollege());
//        goodsVo.setDorm(user.getStuDorm());
//        goodsVo.setTel(user.getStuTel());
//        return goodsVo;
//    }
//}
