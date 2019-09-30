package com.mars.elleshop.exception;

import com.mars.elleshop.common.JsonBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//@ControllerAdvice // 必须使用该注解
//@ResponseBody
@RestControllerAdvice
public class GlobalExceptionResolver {

    @ExceptionHandler(Exception.class)
    public JsonBean exception(Exception ex){

        return new JsonBean<>(1, ex.getMessage());
    }
}
