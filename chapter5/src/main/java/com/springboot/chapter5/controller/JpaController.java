package com.springboot.chapter5.controller;

import com.springboot.chapter5.converter.SexConverter;
import com.springboot.chapter5.dao.JpaUserRepository;
import com.springboot.chapter5.enumeraction.SexEnum;
import com.springboot.chapter5.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter5.controller
 * @className : JpaController
 * @description : TODO
 * @date : 2022/11/17 13:46
 */
@Controller
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    JpaUserRepository jpaUserRepository = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser (Long id) {
        User user = jpaUserRepository.findById(id).get();
        return user;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public User addUser (String userName, Integer sex, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);

        SexConverter sexConverter = new SexConverter();
        SexEnum sexEnum = sexConverter.convertToEntityAttribute(sex);
        user.setSex(sexEnum);

        return jpaUserRepository.save(user);
    }

}
