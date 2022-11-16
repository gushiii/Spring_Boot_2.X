package com.springboot.chapter3.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.pojo
 * @className : DataBaseProperties
 * @description : TODO
 * @date : 2022/11/15 22:37
 */
@Component
@ConfigurationProperties("database")
@Data
public class DataBaseProperties {

//    @Value("${database.driverName}")
    private String driverName;

//    @Value("${database.url}")
    private String url;

//    @Value("${database.username}")
    private String username;

//    @Value("${database.password}")
    private String password;

}
