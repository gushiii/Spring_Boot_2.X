package com.springboot.chapter4.aspect;

import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.aspect.validator.impl.UserValidatorImpl;
import com.springboot.chapter4.invoke.Invocation;
import com.springboot.chapter4.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.lang.reflect.InvocationTargetException;
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
public class MyAspect {

    @DeclareParents(
            value = "com.springboot.chapter4.aspect.service.impl.UserServiceImpl",
            defaultImpl = UserValidatorImpl.class
    )
    public UserValidator userValidator;

    @Pointcut("execution(* com.springboot.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void printCut () {}

    @Before("printCut()")
    public void before() {
        System.out.println("before ... ");
    }

    @Before("printCut() && args(user)")
    public void beforeParam (JoinPoint point, User user) {
        Object[] args = point.getArgs();
        System.out.println("before ... " + Arrays.toString(args));
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

    @Around("printCut()")
    public void around (ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before ..."); //回调 目标对象的原有方法
        jp.proceed();
        System.out.println("around after ...");
    }
}
