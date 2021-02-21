package com.batis.demobatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * 商品表
 *
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年06月28日 7:54
 * @version: 1.0
 */
@Data
public class Commodity {
    private static final long serialVersionUID = 947157161603658360L;
    /**自增长排序**/
    private String commodityNum;
    /**用户ID**/
    private String userId;
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
    private String contact;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;
}
