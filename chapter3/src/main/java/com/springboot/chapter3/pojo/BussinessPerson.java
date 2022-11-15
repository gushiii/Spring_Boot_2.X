package com.springboot.chapter3.pojo;

import com.springboot.chapter3.pojo.definition.Animal;
import com.springboot.chapter3.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Animal cat = null;
//    private Animal animal = null;

    @Override
    public void service() {
//        this.animal.use();
        this.cat.use();
    }

    @Override
    public void setAnimal(Animal animal) {
//        this.animal = animal;
        this.cat = animal;
    }
}
