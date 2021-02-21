package com.batis.demobatis.util;

public class CampusException extends RuntimeException {
    /***
     *通用异常
     * @param resultEnum
     * @return
     * @author lc
     * @createTime 2020/5/8 22:40
     *
     */
    public CampusException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

    }
}
