package com.springboot.chapter3.pojo;

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
public class DataBaseProperties {

//    @Value("${database.driverName}")
    private String driverName;

//    @Value("${database.url}")
    private String url;

//    @Value("${database.username}")
    private String username;

//    @Value("${database.password}")
    private String password;

    public String getDriverName() {
        return driverName;
    }


    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataBaseProperties{" +
                "driverName='" + driverName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
