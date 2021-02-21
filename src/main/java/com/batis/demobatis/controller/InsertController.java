package com.batis.demobatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.entity.PickGoods;
import com.batis.demobatis.service.impl.ExpressServiceImpl;
import com.batis.demobatis.service.impl.LostGoodsServiceImpl;
import com.batis.demobatis.service.impl.PickGoodsServiceImpl;
import com.batis.demobatis.util.InsertImg;
import com.batis.demobatis.util.Result;
import com.batis.demobatis.util.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 添加物品数据功能
 *
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年06月13日 10:46
 * @version: 1.0
 */
@RestController
@RequestMapping("insert")
public class InsertController {
    @Autowired
    LostGoodsServiceImpl lostGoodsService;
    @Autowired
    PickGoodsServiceImpl pickGoodsService;
    @Autowired
    ExpressServiceImpl expressService;
    @Autowired
    private InsertImg insertImg;

    @RequestMapping(value = "/goodsInsert", method = RequestMethod.POST, consumes = "multipart/form-data")
    public Result Insert(HttpServletRequest request,
                         MultipartFile file) throws IOException {
        //获取前台数据
        String goods = request.getParameter("goods");
        //实例化图片添加的对象
        //InsertImg insertImg = new InsertImg();
        //返回添加本地后图片的路径
        String newFile = insertImg.insertImg(file);
        //json化传过来的数据
        JSONObject jsonObject = JSONObject.parseObject(goods);
        //数据
        String wXUuId = (String) jsonObject.get("wXUuId");
        String product = (String) jsonObject.get("product");
        String address = (String) jsonObject.get("address");
        String content = (String) jsonObject.get("content");
        String tel = (String) jsonObject.get("tel");
        String type = (String) jsonObject.get("type");
        List<Object> goodsList = new ArrayList<>();
//        System.out.println(jsonObject);
        if (!newFile.isEmpty()) {
            //拼接图片url，传入tomcat
            String url = "http://localhost:8081/images/" + newFile;
            if ("pickadd".equals(type)) {

                PickGoods pickGoods = new PickGoods();
                insertImg.insertText(pickGoods, wXUuId, url, product, address, content, tel);
                pickGoodsService.insert(pickGoods);
                List<LostGoods> lostGoodsList = lostGoodsService.selectAllByPickProduct(product);
                insertImg.changeList(goodsList, lostGoodsList);
            } else if ("lostadd".equals(type)) {

                LostGoods lostGoods = new LostGoods();
                insertImg.insertText(lostGoods, wXUuId, url, product, address, content, tel);
                lostGoodsService.insert(lostGoods);
                List<PickGoods> pickGoodsList = pickGoodsService.selectAllByLostProduct(product);
                insertImg.changeList(goodsList, pickGoodsList);
            }
            System.out.println(Result.success(goodsList));
            return Result.success(goodsList);
        } else {
            return Result.Error(ResultEnum.RESULT_ENUM_ADD_RECORD_NULL,"数据为空");
        }

    }
}
