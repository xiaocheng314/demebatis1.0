package com.batis.demobatis.util;


import lombok.Data;

import org.jetbrains.annotations.NotNull;


@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(@NotNull ResultEnum resultEnum, T data) {
        this.code=resultEnum.getCode();
        this.message=resultEnum.getMessage();
        this.data=data;
    }

    public static Result<Void> success(){
        return new Result<Void>(ResultEnum.SUCCESS,null);
    }
    public static <T>Result<T> success(T data){
        return new Result<T>(ResultEnum.SUCCESS,data);
    }
    /* 通用失败返回状态. */
    @NotNull
    public static<T> Result<T> Error(@NotNull ResultEnum resultEnum,T data) {
        return new Result<T>(resultEnum,data);
    }

}
