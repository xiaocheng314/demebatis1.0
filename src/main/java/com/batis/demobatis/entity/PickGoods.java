package com.batis.demobatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 寻找物品的表(PickGoods)实体类
 *
 * @author lc
 * @since 2020-05-12 19:01:44
 */
@Data
public class PickGoods implements Serializable {
    private static final long serialVersionUID = -15524565721014191L;
    /**
     * 编号
     */
    private Integer pickNumber;
    /**
     * 捡到的用户
     */
    private String pickWxOpenId;
    /**
     * 捡到物品的图片
     */
    private String pickImg;
    /**
     * 捡到物品
     */
    private String pickProduct;
    /**
     * 捡到的地点
     */
    private String pickAddress;
    /**
     * 物品的大概描述
     */
    private String pickContent;
    /**
     * 物品是否找到，默认false即'0'
     */
    private boolean pickReturn;
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