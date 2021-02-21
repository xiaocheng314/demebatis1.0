package com.batis.demobatis.util;

import com.batis.demobatis.entity.LostGoods;
import com.batis.demobatis.entity.PickGoods;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


/**
 * 添加图片到本地储存
 *
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年06月05日 23:58
 * @version: 1.0
 */
@Component
public class InsertImg {
    public String insertImg(MultipartFile file) throws IOException {
        System.out.println(file);
        if (!file.isEmpty()) {
            //获取图片名file
            String tempFile = file.getOriginalFilename();
            //获取图片后缀
            String type = tempFile.substring(tempFile.lastIndexOf("."));
            //储存文件的绝对地址
            String filePath = "D:\\checkimage\\";
//            String filePath = request.getSession().getServletContext().getRealPath("/");
            //随机生成新的图片名
            String uuid = UUID.randomUUID().toString();

            String newFile = uuid + type;
            //储存在本地地址
            String path = filePath + newFile;
            File file1 = new File(path);
            //是否存在文件夹
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            file.transferTo(file1);
//            System.out.println(file1.getAbsoluteFile());
            return newFile;
        } else {
            throw new CampusException(ResultEnum.RESULT_IMG_EXIST);
        }
    }

    public PickGoods insertText(PickGoods pickGoods, String wXUuId, String url, String product, String address, String content,
                             String tel) {
        pickGoods.setPickWxOpenId(wXUuId);
        pickGoods.setPickImg(url);
        pickGoods.setPickProduct(product);
        pickGoods.setPickAddress(address);
        pickGoods.setPickContent(content);
        pickGoods.setTel(tel);

        return pickGoods;
    }

    public LostGoods insertText(LostGoods lostGoods, String wXUuId, String url, String product, String address, String content,
                             String tel) {
        lostGoods.setLostWxOpenId(wXUuId);
        lostGoods.setLostImg(url);
        lostGoods.setLostProduct(product);
        lostGoods.setLostAddress(address);
        lostGoods.setLostContent(content);
        lostGoods.setTel(tel);

        return lostGoods;
    }

    public List changeList(List goodList, List inList) {
        for (int i = 0; i < inList.size() ;i++) {
            goodList.add(inList.get(i));
        }
        return goodList;
    }
}