package com.springboot.chapter3.config;

import com.springboot.chapter3.pojo.BussinessPerson;
import com.springboot.chapter3.pojo.User1;
import com.springboot.chapter3.pojo.User3;
import com.springboot.chapter3.pojo.definition.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : chapter1
 * @package : com.springboot.chapter3.config
 * @className : IoCTest
 * @description : TODO
 * @date : 2022/11/15 17:34
 */
public class IoCTest {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User1 user1 = ctx.getBean(User1.class);
        System.out.println(user1);
        User2 user2 = ctx.getBean(User2.class);
        System.out.println(user2);
        User3 user3 = ctx.getBean(User3.class);
        System.out.println(user3);
        System.out.println("=========================");
        System.out.println(ctx.containsBean("dataSource"));
        System.out.println("=========================");
        Person person = ctx.getBean(BussinessPerson.class);
        person.service();
        ctx.close();
    }

}
