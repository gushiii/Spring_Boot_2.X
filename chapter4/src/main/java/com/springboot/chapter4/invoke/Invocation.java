package com.springboot.chapter4.invoke;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.invoke
 * @className : Invocation
 * @description : TODO
 * @date : 2022/11/16 15:30
 */
@Getter
@Setter
@Data
public class Invocation {

    private Object[] params;

    private Method method;

    private Object target;

    public Invocation(Object[] params, Method method, Object target) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    public Object proceed () throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target,params);
    }
}
