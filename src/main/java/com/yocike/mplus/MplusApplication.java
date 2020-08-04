package com.yocike.mplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yocike.mplus.mapper")
public class MplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MplusApplication.class, args);
    }

}
