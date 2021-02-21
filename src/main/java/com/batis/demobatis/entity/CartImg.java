package com.batis.demobatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 这是商品储存的三张图片
 *
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年06月28日 8:10
 * @version: 1.0
 */
@Data
public class CartImg {
    private String oneImg;
    private String twoImg;
    private String threeImg;
    private String  commodityNum;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
}
