package com.springboot.chapter4;

import com.springboot.chapter4.service.HelloService;
import com.springboot.chapter4.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chapter4ApplicationTests {

    @Test
    void contextLoads() {

        HelloService helloService = new HelloServiceImpl();

    }

}
