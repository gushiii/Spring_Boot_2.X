package com.springboot.chapter3.config;

import com.springboot.chapter3.condition.DatabaseConditional;
import com.springboot.chapter3.pojo.User1;
import com.springboot.chapter3.pojo.User3;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.sql.DataSourceDefinition;
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
@ImportResource(value = {"classpath:spring-other.xml"})
public class AppConfig {

    @Bean(name = "user")
    public User1 initUser () {
        User1 user1 = new User1();
        user1.setId(1L);
        user1.setUserName("user_name_1");
        user1.setNote("note_1");
        return user1;
    }

    @Bean(name = "dataSource", destroyMethod = "close")
    @Conditional(DatabaseConditional.class)
    public DataSource getDataSource (
            @Value("${database.driverName}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String password
    ) {
        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean(name = "dataSource", destroyMethod = "close")
    @Profile("dev")
    public DataSource getDevDataSource () {
        Properties props = new Properties();
        props.setProperty("driver", "driver");
        props.setProperty("url", "url/dev");
        props.setProperty("username", "username");
        props.setProperty("password", "password");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean(name = "dataSource", destroyMethod = "close")
    @Profile("test")
    public DataSource getTestDataSource () {
        Properties props = new Properties();
        props.setProperty("driver", "driver");
        props.setProperty("url", "url/test");
        props.setProperty("username", "username");
        props.setProperty("password", "password");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataSource;
    }
}
