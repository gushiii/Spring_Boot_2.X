package com.springboot.chapter3.pojo;

import com.springboot.chapter3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.pojo
 * @className : Dog
 * @description : TODO
 * @date : 2022/11/15 19:54
 */
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗 [ " + Dog.class.getSimpleName() + " ] 是看门用的");
    }
}
