package com.ey.hc.ums;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="com.ey.ums.dao" )
public class AppAplication {


    public static void main(String[] args) {
        SpringApplication.run(AppAplication.class,args);
    }
}
