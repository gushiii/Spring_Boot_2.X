package com.springboot.chapter3.pojo;

import com.springboot.chapter3.pojo.definition.Animal;
import com.springboot.chapter3.pojo.definition.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.pojo
 * @className : BussinessPerson
 * @description : TODO
 * @date : 2022/11/15 19:52
 */
@Component
public class BussinessPerson implements Person, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

//    @Autowired
    private  Animal animal = null;

//    public BussinessPerson(@Autowired @Qualifier("dog") Animal animal) {
//        this.animal = animal;
//    }
    //    private Animal cat = null;

    @Override
    public void service() {
        this.animal.use();
//        this.cat.use();
    }

    @Override
    @Autowired @Qualifier("squirrel")
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
//        this.cat = animal;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("[ " + this.getClass() .getSimpleName() +
                " ] 调用 BeanNameAware 的 setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[ " + this.getClass() .getSimpleName() +
                " ] 调用 BeanFactoryAware 的 setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("[ " + this.getClass() .getSimpleName() +
                " ] 调用 ApplicationContextAware 的 setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[ " + this.getClass() .getSimpleName() +
                " ] 调用 InitializingBean 的 afterPropertiesSet");
    }

    @PostConstruct
    public void init () {
        System.out.println("[ " + this.getClass() .getSimpleName() +
                " ] 注解 @PostConstruct 定义的自定义初始化方法 ");
    }

    @PreDestroy
    public void destroy1 () {
        System.out.println("[ " + this.getClass() .getSimpleName() +
                " ] 注解 @PreDestroy 定义的自定义销毁方法 ");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[ " + this.getClass() .getSimpleName() +
                " ] 调用 DisposableBean 的 destroy");
    }
}
