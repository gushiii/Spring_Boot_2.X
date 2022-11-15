package com.springboot.chapter3.config;

import com.springboot.chapter3.pojo.User1;
import com.springboot.chapter3.pojo.User3;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : chapter1
 * @package : com.springboot.chapter3.config
 * @className : AppConfig
 * @description : TODO
 * @date : 2022/11/15 17:15
 */
@Configuration
//@ComponentScan
//@ComponentScan("com.springboot.chapter3.*")
//@ComponentScan(basePackages = {"com.springboot.chapter3.pojo"})
//@ComponentScan(basePackageClasses = User3.class)
@ComponentScan(basePackages = "com.springboot.chapter3.*",
    excludeFilters = {@ComponentScan.Filter(classes = Service.class)},
    lazyInit = true
)
public class AppConfig {

    @Bean(name = "user")
    public User1 initUser () {
        User1 user1 = new User1();
        user1.setId(1L);
        user1.setUserName("user_name_1");
        user1.setNote("note_1");
        return user1;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource () {
        Properties props = new Properties();
        props.setProperty("driver","com.mysql.cj.jdbc.Driver");
        props.setProperty("url","jdbc:mysql://localhost:3306/chapter3");
        props.setProperty("username","root");
        props.setProperty("password","10142556");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }
}
