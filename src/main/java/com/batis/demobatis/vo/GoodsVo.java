package com.batis.demobatis.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @projectName: demebatis1.0
 * @author: Administrator
 * @date: 2020年05月15日 19:16
 * @version: 1.0
 */
@Data
public class GoodsVo {
    private int id;
    private String name;
    private String grade;
    private String college;
    private String img;
    private String dorm;
    private String product;
    private String tel;
}
