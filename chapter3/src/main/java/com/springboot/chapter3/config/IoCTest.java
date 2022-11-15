package com.springboot.chapter3.config;

import com.springboot.chapter3.pojo.User3;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

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

    private static Logger log = Logger.getLogger(IoCTest.class);
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//        User1 user1 = ctx.getBean(User1.class);
//        log.info(user1);
//        User2 user2 = ctx.getBean(User2.class);
//        log.info(user2);
        User3 user3 = ctx.getBean(User3.class);
        log.info(user3);
        log.info("=========================");
        log.info(ctx.containsBean("dataSource"));
    }

}
