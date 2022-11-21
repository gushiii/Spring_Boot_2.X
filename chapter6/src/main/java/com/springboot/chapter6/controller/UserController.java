package com.springboot.chapter6.controller;

import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.UserBatchService;
import com.springboot.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    private UserBatchService userBatchService = null;

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

    @RequestMapping("insertUsers")
    @ResponseBody
    public Map<String, Object> insertUsers (String userName1, String note1, String userName2, String note2) {

        User user1 = new User();
        user1.setUserName(userName1);
        user1.setNote(note1);

        User user2 = new User();
        user2.setUserName(userName2);
        user2.setNote(note2);

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        int inserts = userBatchService.insertUser(userList);

        Map<String, Object> result = new HashMap<>();

        result.put("success", inserts > 0);
        result.put("user", userList);

        return result;
    }

}
