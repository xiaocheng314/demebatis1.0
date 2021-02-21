//package com.batis.demobatis.controller;
//
//import com.batis.demobatis.entity.PickGoods;
//import com.batis.demobatis.service.impl.PickGoodsServiceImpl;
//
//import com.batis.demobatis.util.*;
//
//import com.batis.demobatis.vo.GoodsVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
///**
// * 寻找物品的表(PickGoods)表控制层
// *
// * @author lc
// * @since 2020-05-12 19:01:44
// */
//@Controller
//@RequestMapping("pickGoods")
//public class PickGoodsController {
//    /**
//     * 服务对象
//     */
//    @Autowired
//    private PickGoodsServiceImpl pickGoodsService;
//
//    /**
//     * 修改物品
//     */
//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    @ResponseBody
//    public Result update(@RequestParam(required = false, value = "number") Integer number,
//                         @RequestParam(required = false, value = "id") String id,
//                         @RequestParam(required=false,value="adminId") String adminId) {
//        PickGoods pickGoods = null;
//        if (id != null && number != null) {
//            pickGoods=new PickGoods();
//            pickGoods.setLostId(id);
//            pickGoods.setPickReturn(true);
//            pickGoods.setPickNumber(number);
//            pickGoods.setLostId(adminId);
//            int result = pickGoodsService.update(pickGoods);
//            pickGoods =  pickGoodsService.queryById(number);
//            UpdateGoods updateGoods = new UpdateGoods();
//            GoodsVo goodsVo = updateGoods.update(id);
//            goodsVo.setProduct(pickGoods.getPickProduct());
//            if (result == 1) {
//                return Result.Ok(goodsVo);
//            } else {
//
//                return Result.Error(ResultEnum.ERROR);
//            }
//        } else {
//            throw new CampusException(ResultEnum.ERROR);
//        }
//    }
//
//    /**
//     * 查询全部寻物启示
//     *
//     * @return
//     * @author lc
//     * @createTime 2020/6/15 21:55
//     */
//    @RequestMapping(value = "pickSelectAll", method = RequestMethod.GET)
//    @ResponseBody
//    public Result selectPickAll() {
//        List<PickGoods> pickGoodsList = pickGoodsService.selectAllPick();
//        System.out.println(pickGoodsList);
//        if (pickGoodsList.isEmpty()) {
//            return Result.Error(ResultEnum.RESULT_USERS_EXISTENT);
//        } else {
//            return Result.Ok(pickGoodsList);
//        }
//    }
//
//    /**
//     * 查询个人全部寻物启示
//     *
//     * @return
//     * @author lc
//     * @createTime 2020/6/15 21:55
//     */
//    @RequestMapping(value = "pickSelectByAll", method = RequestMethod.GET)
//    @ResponseBody
//    public Result pickSelectByAll() {
//        List<PickGoods> pickGoodsList = pickGoodsService.pickQueryByAll();
//        if (pickGoodsList.isEmpty()) {
//            return Result.Error(ResultEnum.RESULT_USERS_EXISTENT);
//        } else {
//            return Result.Ok(pickGoodsList);
//        }
//    }
//
//    /**
//     * 查询全部失物招领
//     *
//     * @return
//     * @author lc
//     * @createTime 2020/6/15 21:57
//     */
//    @RequestMapping(value = "pickSelectBy", method = RequestMethod.POST)
//    @ResponseBody
//    public Result ById(@RequestParam(value = "id",required = false) int id){
//        List<PickGoods> pickGoods=pickGoodsService.queryAllBy(id);
//        return Result.Ok(pickGoods);
//    }
//
//
//}