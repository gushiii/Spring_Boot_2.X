package com.springboot.chapter4.aspect.controller;

import com.springboot.chapter4.aspect.service.UserService;
import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.aspect.controller
 * @className : UserController
 * @description : TODO
 * @date : 2022/11/16 19:56
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService = null;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser (Long id, String userName, String note) {
//        User user = null;
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        userService.printUser(user);
        return user;
    }

    @ResponseBody
    @RequestMapping("vp")
    public User validatorAndPrint (Long id, String userName, String note) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);

        UserValidator userValidator = (UserValidator) userService;
        if (userValidator.validator(user)) {
            userService.printUser(user);
        }
        return user;
    }

}
