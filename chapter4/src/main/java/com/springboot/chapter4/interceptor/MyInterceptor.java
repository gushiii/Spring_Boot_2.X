package com.springboot.chapter4.interceptor;

import com.springboot.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.interceper
 * @className : MyInterceptor
 * @description : TODO
 * @date : 2022/11/16 15:36
 */
public class MyInterceptor implements Interceptor{
    @Override
    public boolean before() {
        System.out.println("before ... ");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after ... ");
    }

    @Override
    public Object around(Invocation invocation)
            throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before ... ");
        Object obj = invocation.proceed();
        System.out.println("around after ... ");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning ... ");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing ... ");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
