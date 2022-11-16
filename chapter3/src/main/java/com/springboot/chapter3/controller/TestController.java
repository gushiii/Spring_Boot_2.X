package com.springboot.chapter3.controller;

import com.springboot.chapter3.config.AppConfig;
import com.springboot.chapter3.config.User2;
import com.springboot.chapter3.pojo.*;
import com.springboot.chapter3.pojo.definition.Person;
import com.springboot.chapter3.scope.pojo.ScopeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.controller
 * @className : TestController
 * @description : TODO
 * @date : 2022/11/15 23:11
 */
@Controller
public class TestController {

    @Autowired
    DataBaseProperties dataBaseProperties;

    @Autowired
    public ApplicationContext ctx;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    @ResponseBody
    public void test () {

        User1 user1 = ctx.getBean(User1.class);
        System.out.println(user1);
        User2 user2 = ctx.getBean(User2.class);
        System.out.println(user2);
        User3 user3 = ctx.getBean(User3.class);
        System.out.println(user3);

        System.out.println("<=======================================>");
        Person person = ctx.getBean(BussinessPerson.class);
        person.service();

        System.out.println("<=======================================>");
        DataBaseProperties dataBaseProperties = ctx.getBean(DataBaseProperties.class);
        System.out.println(dataBaseProperties.getDriverName());

        System.out.println("<=======================================>");
        System.out.println(ctx.getBean("dataSource"));

        System.out.println("<=======================================>");
        ScopeBean scopeBean1 = ctx.getBean(ScopeBean.class);
        ScopeBean scopeBean2 = ctx.getBean(ScopeBean.class);
        System.out.println("scopeBean1 == scopeBean2 : " + (scopeBean1 == scopeBean2));

        System.out.println("<=======================================>");
        String[] beanNamesForType = ctx.getBeanNamesForType(DataSource.class);
        System.out.println(Arrays.toString(beanNamesForType));

        System.out.println("<=======================================>");
        SpringEL springEL = ctx.getBean(SpringEL.class);
        System.out.println(springEL);

    }

}
