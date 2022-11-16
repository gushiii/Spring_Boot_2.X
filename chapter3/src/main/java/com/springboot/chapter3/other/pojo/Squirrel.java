package com.springboot.chapter3.other.pojo;

import com.springboot.chapter3.pojo.definition.Animal;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.other.pojo
 * @className : Squirrel
 * @description : TODO
 * @date : 2022/11/16 12:14
 */
public class Squirrel implements Animal {
    @Override
    public void use() {
        System.out.println("松鼠可以采集松果");
    }
}
