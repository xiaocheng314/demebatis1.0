package com.batis.demobatis.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;


/**
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年06月28日 10:26
 * @version: 1.0
 */
@Data
public class CommodityVo {
    private static final long serialVersionUID = 947157161603658360L;
    /**自增长排序**/
    private String commodityNum;
    /**用户ID**/
    private Integer userId;
    /**商品名称**/
    private String product;
    /**商品描述**/
    private String content;
    /**商品类型**/
    private String kind;
    /**商品是否全新**/
    private boolean isNew;
    /**商品价格**/
    private Integer price;
    /**交易地址*/
    private String address;
    /**联系方式**/
    private long contact;
    /**
     * 图片列表
     **/
    private String oneImg;
    private String twoImg;
    private String threeImg;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;
}
