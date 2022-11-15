package com.springboot.chapter3.pojo;

import com.springboot.chapter3.pojo.definition.Animal;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.pojo
 * @className : Cat
 * @description : TODO
 * @date : 2022/11/15 20:33
 */
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫 [ " + Dog.class.getSimpleName() + " ] 是抓老鼠用的");
    }
}
