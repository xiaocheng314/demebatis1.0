package com.batis.demobatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Express)实体类
 *
 * @author lc
 * @since 2020-05-12 19:03:22
 */
@Data
public class Express implements Serializable {
    private static final long serialVersionUID = -71892758061063546L;
    
    private String stuId;
    
    private String stuName;
    
    private Integer expressShelves;
    
    private String expressNumber;
    
    private Integer expressId;

}