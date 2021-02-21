package com.batis.demobatis.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    /* 返回统一的错误成功信息. */
    ERROR(0, "错误"),
    SUCCESS(1, "成功"),
    /* 添加物品数据为空 */
    RESULT_ENUM_ADD_RECORD_NULL(202,"添加物品数据为空"),
    /* 物品数据为空，没有数据返回 */
    RESULT_GOODS_NULL(203,"物品数据为空，没有数据返回"),
    /* 用户的统一信息. */
    RESULT_USER_SUCCESS_LOGIN(5, "注册成功"),
    RESULT_USER_EXIST_FILED(3, "已有用户"),
    /* 失物的统一信息. */
    RESULT_LOST_GOODS_NULL(4, "用户数据为空"),
    /* 寻物的统一信息. */
    RESULT_PICK_IMG_FILE_NULL(7,"寻物图片为空"),
    /* 图片存在. */
    RESULT_IMG_EXIST(8,"图片已存在"),
    /* wx获取信息 */
    WX_RESULT_RESOLVE_MSG_ERROR(201,"登录错误,数据有错误,请重新登录"),
    /* 我的丢失物 */
    RESULT_MY_LOST_LIST_NULL(9,"我的丢失列表为空"),
    /* 我的捡到物 */
    RESULT_MY_PICK_LIST_NULL(10,"我的捡到列表为空"),
    /* 我的捡到物 */
    RESULT_UQDATE_PICK_RETURN(500,"系统超时"),

            ;
    private int code;
    private String message;
}
