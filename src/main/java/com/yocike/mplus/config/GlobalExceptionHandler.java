package com.yocike.mplus.config;

import oracle.jrockit.jfr.StringConstantPool;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IOException.class)
    @ResponseBody
    public String woca(){
        return "逮住九是干";
    }
}
