package com.springboot.chapter4.service.impl;

import com.springboot.chapter4.service.HelloService;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.service.impl
 * @className : HelloServiceImpl
 * @description : TODO
 * @date : 2022/11/16 15:21
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException("parameter is null !!");
        }
        System.out.println("hello " + name);
    }
}
