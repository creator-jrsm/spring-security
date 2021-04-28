package com.yDie.utils.exceptionhandler;

import com.yDie.utils.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    //指定了什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody       //为了返回数据
    public R error(Exception e){
        e.printStackTrace();
        log.error(e.getMessage());      //输出到日志
        return R.error().message("执行了全局异常处理...");
    }


}
