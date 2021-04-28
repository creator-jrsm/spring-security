package com.eshore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.eshore.mapper")
public class MainSecurity {
    public static void main(String[] args) {
        SpringApplication.run(MainSecurity.class,args);
    }
}
