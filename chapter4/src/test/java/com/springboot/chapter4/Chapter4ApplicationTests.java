package com.springboot.chapter4;

import com.springboot.chapter4.interceptor.MyInterceptor;
import com.springboot.chapter4.proxy.ProxyBean;
import com.springboot.chapter4.service.HelloService;
import com.springboot.chapter4.service.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chapter4ApplicationTests {

    @Test
    void contextLoads() {

        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());

        proxy.sayHello ("hangman");
        System.out.println("\n############### name is null !! ###############\n");
        proxy.sayHello(null);

    }

}
