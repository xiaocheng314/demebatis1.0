//package com.batis.demobatis.controller;
//
//import com.batis.demobatis.entity.LostGoods;
//import com.batis.demobatis.service.impl.LostGoodsServiceImpl;
//import com.batis.demobatis.util.CampusException;
//import com.batis.demobatis.util.Result;
//import com.batis.demobatis.util.ResultEnum;
//import com.batis.demobatis.util.UpdateGoods;
//import com.batis.demobatis.vo.GoodsVo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * 失物招领的表(LostGoods)表控制层
// *
// * @author lc
// * @since 2020-05-12 19:02:18
// */
//@Controller
//@RequestMapping("lostGoods")
//public class LostGoodsController {
//    /**
//     * 服务对象
//     */
//
//    @Autowired
//    private LostGoodsServiceImpl lostGoodsService;
//
//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    @ResponseBody
//    public Result update(@RequestParam(required = false, value = "number") Integer number,
//                         @RequestParam(required = false, value = "id") String id,
//                         @RequestParam(required = false, value = "adminId") String adminId) {
//        if (id != null && number != null) {
//            LostGoods lostGoods = new LostGoods();
//            lostGoods.setPickId(id);
//            lostGoods.setLostReturn(true);
//            lostGoods.setLostNumber(number);
//            lostGoods.setPickId(adminId);
//            int result = lostGoodsService.update(lostGoods);
//            //
//            lostGoods = lostGoodsService.queryById(number);
//
//            UpdateGoods updateGoods = new UpdateGoods();
//            GoodsVo goodsVo = updateGoods.update(id);
//
//            goodsVo.setProduct(lostGoods.getLostProduct());
//            if (result == 1) {
//                return Result.Ok(goodsVo);
//            } else {
//                return Result.Error(ResultEnum.ERROR);
//            }
//        } else {
//            throw new CampusException(ResultEnum.ERROR);
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
//    @RequestMapping(value = "lostSelectAll", method = RequestMethod.GET)
//    @ResponseBody
//    public Result selectLostAll() {
//        List<LostGoods> lostGoodsList = lostGoodsService.selectLostAll();
//        if (lostGoodsList.isEmpty()) {
//            return Result.Error(ResultEnum.RESULT_LOST_GOODS_NULL);
//        } else {
//            return Result.Ok(lostGoodsList);
//        }
//    }
//
//
//
//
//    /**
//     * 查询全部失物招领
//     *
//     * @return
//     * @author lc
//     * @createTime 2020/6/15 21:57
//     */
//    @RequestMapping(value = "lostSelectBy", method = RequestMethod.POST)
//    @ResponseBody
//    public Result ById(@RequestParam(value = "id",required = false) int id){
//        List<LostGoods> lostGoods=lostGoodsService.queryAllBy(id);
//        return Result.Ok(lostGoods);
//    }
//
//}