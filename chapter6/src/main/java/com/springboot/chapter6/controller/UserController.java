package com.springboot.chapter6.controller;

import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter6.controller
 * @className : UserController
 * @description : TODO
 * @date : 2022/11/18 15:08
 */
@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("getUser")
    @ResponseBody
    public User getUser (Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("insertUser")
    @ResponseBody
    public Map<String, Object> insertUser (String userName, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);

        Map<String, Object> result = new HashMap<>();
        int update = userService.insertUser(user);
        result.put("success", update == 1);
        result.put("user", user);

        return result;
    }
}
