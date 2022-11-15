package com.springboot.chapter3.pojo;

import com.springboot.chapter3.pojo.definition.Animal;
import com.springboot.chapter3.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.pojo
 * @className : BussinessPerson
 * @description : TODO
 * @date : 2022/11/15 19:52
 */
@Component
public class BussinessPerson implements Person {

//    @Autowired
    private  Animal animal = null;

//    public BussinessPerson(@Autowired @Qualifier("dog") Animal animal) {
//        this.animal = animal;
//    }
    //    private Animal cat = null;

    @Override
    public void service() {
        this.animal.use();
//        this.cat.use();
    }

    @Override
    @Autowired @Qualifier("dog")
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
//        this.cat = animal;
    }
}
