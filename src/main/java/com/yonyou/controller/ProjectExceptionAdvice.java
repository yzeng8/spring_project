package com.yonyou.controller;

import com.yonyou.exception.BusinessException;
import com.yonyou.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public Map<String,Object> BussinessHandleException(BusinessException e){
        System.out.println("Business Exception can be handled here ...");
        Map<String,Object> result=new HashMap<>();
        result.put("data",null);
        result.put("msg",e.getMessage());
        return result;
        //记录日志
        //运维
        //返回消息
    }

    @ExceptionHandler(SystemException.class)
    public Map<String,Object> SystemHandleException(SystemException e){
        System.out.println("System Exception can be handled here ...");
        Map<String,Object> result=new HashMap<>();
        result.put("data",null);
        result.put("msg",e.getMessage());
        return result;
        //记录日志
        //运维
        //返回消息
    }
}
