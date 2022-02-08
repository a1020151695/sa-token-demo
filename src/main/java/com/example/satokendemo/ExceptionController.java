package com.example.satokendemo;


import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Cola
 * @description
 * @date 2022/1/15
 * @email 1020151695@qq.com
 */
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    public SaResult handleException(Exception e){
        if(e instanceof NotLoginException){
            return SaResult.error("用户未登录");
        }
        return SaResult.error("系统异常！");
    }
}
