package com.batis.demobatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.WatchEvent;

@SpringBootApplication
@MapperScan("com.batis.demobatis.dao")
public class DemoBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBatisApplication.class, args);
    }

}
