package com.springboot.chapter4.aspect;

import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.aspect.validator.impl.UserValidatorImpl;
import com.springboot.chapter4.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

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
//@Order(3)
public class MyAspect1 implements Ordered {

    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects () {}

    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect1 before ... ");
    }

    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect1 after ... ");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect1 afterReturning ... ");
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
