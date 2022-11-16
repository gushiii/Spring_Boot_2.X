package com.springboot.chapter3.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.pojo
 * @className : BeanName
 * @description : TODO
 * @date : 2022/11/16 14:57
 */
@Component
@Data
public class BeanName {

    @Value("#{'使用 Spring EL 赋值字符串'}")
    private String str = null;

    @Value("#{9.3E3}")
    private double d;

    @Value("#{3.14}")
    private float pi;

}
