package com.batis.demobatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 失物招领的表(LostGoods)实体类
 *
 * @author lc
 * @since 2020-05-12 19:02:18
 */
@Data
public class LostGoods implements Serializable {
    private static final long serialVersionUID = 833575065633675154L;
    /**
     * 编号
     */
    private Integer lostNumber;
    /**
     * 丢失的用户
     */
    private String lostWxOpenId;
    /**
     * 丢失物品的图片
     */
    private String lostImg;
    /**
     * 丢失物品
     */
    private String lostProduct;
    /**
     * 丢失的地点
     */
    private String lostAddress;
    /**
     * 物品的大概描述
     */
    private String lostContent;
    /**
     * 物品是否找到，默认false即'0'
     */
    private boolean lostReturn;
    /**
     * 电话
     */
    private String tel;
    /**
     * 添加的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;

}