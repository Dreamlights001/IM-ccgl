package com.manufacturing.storagecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.manufacturing.storagecenter.mapper")
public class StorageCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageCenterApplication.class, args);
    }

}