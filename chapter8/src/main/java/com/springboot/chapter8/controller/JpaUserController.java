package com.springboot.chapter8.controller;

import com.springboot.chapter8.pojo.User;
import com.springboot.chapter8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter8.controller
 * @className : JpaUserController
 * @description : TODO
 * @date : 2022/11/22 15:25
 */
@RequestMapping("/jpa")
@Controller
public class JpaUserController {

    @Autowired
    UserRepository userRepository = null;

    @RequestMapping("/byName")
    @ResponseBody
    public List<User> findByUserName (String userName) {
        return userRepository.findByUserNameLike(userName);
    }
    @RequestMapping("/byIdOrName")
    public User findUserByIdOrUserName (Long id, String userName) {
        return userRepository.findUserByIdOrUserName(id, userName);
    }

}
