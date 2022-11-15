package com.springboot.chapter3.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.life
 * @className : BeanPostProcessorExampIe
 * @description : TODO
 * @date : 2022/11/15 22:12
 */
@Component
public class BeanPostProcessorExample implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println ("BeanPostProcessor 调用 "
                + "postProcessBeforeInitialization 方法,参数 [ "
                + bean.getClass().getSimpleName()
                + "] [" + beanName + "]");
        return bean;

    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println ("BeanPostProcessor 调用 "
                + "postProcessAfterInitialization 方法,参数 [ "
                + bean.getClass().getSimpleName()
                + "] [" + beanName + "]");
        return bean;
    }
}
