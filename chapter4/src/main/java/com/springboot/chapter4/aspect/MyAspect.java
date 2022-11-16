package com.springboot.chapter4.aspect;

import com.springboot.chapter4.invoke.Invocation;
import org.aspectj.lang.annotation.*;

import java.lang.reflect.InvocationTargetException;

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
public class MyAspect {

    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void printCut () {}

    @Before("printCut()")
    public void before() {
        System.out.println("before ... ");
    }

    @After("printCut()")
    public void after() {
        System.out.println("after ... ");
    }

    @AfterReturning("printCut()")
    public void afterReturning() {
        System.out.println("afterReturning ... ");
    }

    @AfterThrowing("printCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing ... ");
    }


}
