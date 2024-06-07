package com.yonyou.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public Map<String,Object> HandleException(Exception e){
        System.out.println("Exception can be handled here ...");
        Map<String,Object> result=new HashMap<>();
        result.put("data",null);
        result.put("msg","数据异常");
        return result;
    }
}
