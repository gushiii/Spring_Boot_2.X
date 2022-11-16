package com.springboot.chapter3.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.pojo
 * @className : SpringEL
 * @description : TODO
 * @date : 2022/11/16 14:35
 */
@Component
@Data
public class SpringEL {

    @Value("#{beanName.str}")
    private String str = null;

    @Value("#{beanName.d}")
    private double d;

    @Value("#{beanName.pi}")
    private float pi;

//    @Value("#{user3.userName}")
    @Value("#{beanName.str?.toUpperCase()}")
    private String otherBeanProp = null;

    @Value("#{1 + 2}")
    private int run;

    @Value("#{beanName.pi == 3.14}")
    private boolean piFlag;

    @Value("#{beanName.str eq 'Spring Boot'}")
    private boolean strFlag;

    @Value("#{beanName.str + ' 连接字符串'}")
    private String strApp = null;

    @Value("#{beanName.d > 1000 ? '大于' : '小于'}")
    private String resultDesc = null;

}
