package com.yDie.utils.exceptionhandler;

import lombok.Data;

@Data
public class GuliException  extends  RuntimeException{

    //状态码
    private Integer code;

    //异常信息
    private  String msg;
}
