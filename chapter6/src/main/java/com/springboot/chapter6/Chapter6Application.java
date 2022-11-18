package com.springboot.chapter6;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan(
        basePackages = "com.springboot.chapter6",
        annotationClass = Repository.class
)
public class Chapter6Application {

    @Autowired
    PlatformTransactionManager transactionManager = null;

    public static void main(String[] args) {
        SpringApplication.run(Chapter6Application.class, args);
    }

    @PostConstruct
    public void viewTransactionManager () {
        System.out.println("======================================");
        System.out.println(transactionManager.getClass().getName());
        System.out.println("======================================");
    }

}
