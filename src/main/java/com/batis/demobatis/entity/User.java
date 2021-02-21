package com.batis.demobatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author lc
 * @since 2020-05-12 22:12:51
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 947157161603658360L;
    /**
     * uuid
     */
    private String uuId;
    /**
     * openid唯一
     */
    private String openId;
    /**
     * 班级
     */
    private String stuGrade;
    /**
     * 学院
     */
    private String stuCollege;
    /**
     * 宿舍
     */
    private String stuDorm;
    /**
     * 电话
     **/
    private long stuTel;

    /**
     * 注册时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
}