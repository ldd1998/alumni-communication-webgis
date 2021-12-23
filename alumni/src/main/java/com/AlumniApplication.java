package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.mapper")
@SpringBootApplication
public class AlumniApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlumniApplication.class, args);
    }

}