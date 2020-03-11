package com.health;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.health.dao")
public class GooglehealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(GooglehealthApplication.class, args);
    }

}
