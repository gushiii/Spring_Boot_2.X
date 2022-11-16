package com.springboot.chapter4.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.aspect.service
 * @className : MyAspect
 * @description : TODO
 * @date : 2022/11/16 19:39
 */
@Aspect
//@Order(2)
public class MyAspect2 implements Ordered {

    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects () {}

    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect2 before ... ");
    }

    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect2 after ... ");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect2 afterReturning ... ");
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
