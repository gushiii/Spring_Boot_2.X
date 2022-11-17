package com.springboot.chapter5.db;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter5.db
 * @className : DataSourceShow
 * @description : TODO
 * @date : 2022/11/17 09:59
 */
@Component
public class DataSourceShow implements ApplicationContextAware {

    ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("================================");
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getClass().getName());
        System.out.println("================================");
    }
}
