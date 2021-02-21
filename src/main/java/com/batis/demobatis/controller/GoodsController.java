package com.batis.demobatis.controller;

import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.entity.PickGoods;
import com.batis.demobatis.entity.User;
import com.batis.demobatis.service.impl.ExpressServiceImpl;
import com.batis.demobatis.service.impl.LostGoodsServiceImpl;
import com.batis.demobatis.service.impl.PickGoodsServiceImpl;
import com.batis.demobatis.util.Result;
import com.batis.demobatis.util.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年06月15日 21:51
 * @version: 1.0
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private PickGoodsServiceImpl pickGoodsService;
    @Autowired
    private LostGoodsServiceImpl lostGoodsService;
    @Autowired
    private ExpressServiceImpl expressService;

    /**
     * 查询全部寻物启示
     *
     * @return
     * @author lc
     * @createTime 2020/6/15 21:55
     */
    @RequestMapping(value = "pickSelectAll", method = RequestMethod.GET)
    public Result selectPickAll() {
        List<PickGoods> pickGoodsList = pickGoodsService.selectAllPick();
        System.out.println(pickGoodsList);
        if (pickGoodsList.isEmpty()) {
            return Result.Error(ResultEnum.RESULT_GOODS_NULL,"物品数据为空，没有数据返回");
        } else {
            System.out.println(Result.success(pickGoodsList));
            return Result.success(pickGoodsList);
        }
    }

    /**
     * 查询全部失物招领
     *
     * @return
     * @author lc
     * @createTime 2020/6/15 21:57
     */
    @RequestMapping(value = "lostSelectAll", method = RequestMethod.GET)
    public Result selectLostAll() {
        List<LostGoods> lostGoodsList = lostGoodsService.selectLostAll();
        if (lostGoodsList.isEmpty()) {
            return Result.Error(ResultEnum.RESULT_GOODS_NULL,"物品数据为空，没有数据返回");
        } else {
            return Result.success(lostGoodsList);
        }
    }

    @RequestMapping(value = "mylost", method = RequestMethod.GET)
    public Result getMyLost(String lostWxOpenId) {
        List<LostGoods> myLostGoodsList = lostGoodsService.selectLostAllByOpenId(lostWxOpenId);
        System.out.println(myLostGoodsList);
        if (myLostGoodsList.isEmpty()) {
            return Result.Error(ResultEnum.RESULT_MY_LOST_LIST_NULL,"");
        } else {
            return Result.success(myLostGoodsList);
        }
    }

    @RequestMapping(value = "mypick", method = RequestMethod.GET)
    public Result getMyPick(String pickWxOpenId) {
        List<PickGoods> myPickGoodsList = pickGoodsService.selectPickAllByOpenId(pickWxOpenId);
        if (myPickGoodsList.isEmpty()) {
            return Result.Error(ResultEnum.RESULT_MY_PICK_LIST_NULL,"");
        } else {
            return Result.success(myPickGoodsList);
        }
    }

    @RequestMapping(value = "updateLostReturn", method = RequestMethod.POST)
    public Result getMyPick(int lostNumber) {
        boolean isLostReturn = lostGoodsService.getLostReturn(lostNumber);
        if (isLostReturn == false) {
            return Result.Error(ResultEnum.RESULT_UQDATE_PICK_RETURN,"");
        } else {
            return Result.success();
        }
    }

}
