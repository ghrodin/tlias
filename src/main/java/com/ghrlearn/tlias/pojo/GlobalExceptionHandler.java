package com.ghrlearn.tlias.pojo;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//全局异常处理器
public class GlobalExceptionHandler {
//处理异常
    @ExceptionHandler(Exception.class)
    public Result ex(Exception e){
        e.printStackTrace();
        return Result.error("Something Error happened,try to contact adminstrator");
    }

}
