//package com.batis.demobatis.controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.batis.demobatis.entity.CartImg;
//import com.batis.demobatis.entity.Commodity;
//import com.batis.demobatis.service.impl.CartServiceImp;
//import com.batis.demobatis.service.impl.CommodityServiceImp;
//import com.batis.demobatis.util.CampusException;
//import com.batis.demobatis.util.Result;
//import com.batis.demobatis.util.ResultEnum;
//import com.batis.demobatis.vo.CommodityVo;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
///**
// * @projectName: demebatis1.0
// * @author: Administrator
// * @date: 2020年06月28日 8:53
// * @version: 1.0
// */
//@RestController
//@RequestMapping("commodity")
//public class CommodityController {
//    @Autowired
//    CommodityServiceImp commodityServiceImp;
//    @Autowired
//    CartServiceImp cartServiceImp;
//
//    @RequestMapping("commoditySelectAll")
//    public Result selectCommodity() {
//        List<CommodityVo> commodityVoList = commodityServiceImp.commoditySelectAll();
//        if (commodityVoList.isEmpty()) {
//            return Result.Error(ResultEnum.RESULT_LOST_GOODS_NULL);
//        } else {
//            return Result.Ok(commodityVoList);
//        }
//    }
//
//    @RequestMapping(value = "cartInsert", method = RequestMethod.POST, consumes = "multipart/form-data")
//    public String cartInsert(@RequestParam(required = false, value = "file") MultipartFile file) throws IOException {
//        if (!file.isEmpty()) {
//            //获取图片名file
//            String tempFile = file.getOriginalFilename();
//            //获取图片后缀
//            String type = tempFile.substring(tempFile.lastIndexOf("."));
//            //储存文件的绝对地址
//            String filePath = "D:\\checkimage\\";
////            String filePath = request.getSession().getServletContext().getRealPath("/");
//            //随机生成新的图片名
//            String imgId=UUID.randomUUID().toString();
//            String newFile = imgId + type;
//            //储存在本地地址
//            String path = filePath + newFile;
//            File file1 = new File(path);
//            //是否存在文件夹
//            if (!file1.getParentFile().exists()) {
//                file1.getParentFile().mkdirs();
//            } else {
//                file.transferTo(file1);
//                System.out.println(file1.getAbsoluteFile());
//            }
//            return newFile;
//        } else {
//            throw new CampusException(ResultEnum.ERROR);
//        }
//    }
//
//    @RequestMapping(value = "commodityInsert", method = RequestMethod.POST)
//    public Result commodityInsert(
//            @RequestParam(required = false, value = "userId") String uuid,
//            @RequestParam(required = false, value = "product") String product,
//            @RequestParam(required = false, value = "content") String content,
//            @RequestParam(required = false, value = "kind") String kind,
//            @RequestParam(required = false, value = "isNew") boolean isNew,
//            @RequestParam(required = false, value = "price") Integer price,
//            @RequestParam(required = false, value = "address") String address,
//            @RequestParam(required = false, value = "contact") String  contact,
//            @RequestParam(required = false, value = "photo") String photo) {
//
//        String id= UUID.randomUUID().toString();
//
//        if (uuid == null || StringUtils.isEmpty(product) ||
//                StringUtils.isEmpty(content) ||
//                StringUtils.isEmpty(kind)
//              ) {
//            throw new CampusException(ResultEnum.ERROR);
//        } else {
//            System.out.println(photo.length());
//            String str = "";
//            String rs = "";
//            String[] strings = photo.split(",");
//            List listStr = new ArrayList();
//            String url = "http://localhost:8081/images/";
//            for (int i = 0; i < strings.length; i++) {
//                str = strings[i].toString();
//                rs = url+str.substring(str.indexOf('"') + 1, str.lastIndexOf('"'));
//                listStr.add(rs);
//            }
//            System.out.println(listStr.size());
//            Commodity commodity = new Commodity();
//            CartImg cartImg = new CartImg();
//            commodity.setCommodityNum(id);
//            commodity.setUserId(uuid);
//            commodity.setProduct(product);
//            commodity.setKind(kind);
//            commodity.setContent(content);
//            commodity.setNew(isNew);
//            commodity.setPrice(price);
//            commodity.setAddress(address);
//            commodity.setContact(contact);
//            commodity = commodityServiceImp.insert(commodity);
//            System.out.println(commodity);
//            if (listStr.size() == 1) {
//                cartImg.setOneImg((String) listStr.get(0));
//                cartImg.setCommodityNum(id);
//            }
//            if (listStr.size() == 2) {
//                cartImg.setOneImg((String) listStr.get(0));
//                cartImg.setTwoImg((String) listStr.get(1));
//                cartImg.setCommodityNum(id);
//            }
//            if (listStr.size() == 3) {
//                cartImg.setOneImg((String) listStr.get(0));
//                cartImg.setTwoImg((String) listStr.get(1));
//                cartImg.setThreeImg((String) listStr.get(2));
//                cartImg.setCommodityNum
//                        (id);
//            }
//            int res = cartServiceImp.insert(cartImg);
//            return Result.isOk();
//        }
//    }
//}
