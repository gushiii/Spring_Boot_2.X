package com.springboot.chapter8.controller;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.springboot.chapter8.pojo.User;
import com.springboot.chapter8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter8.controller
 * @className : UserController
 * @description : TODO
 * @date : 2022/11/22 00:38
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/page")
    public String page () {
        return "user";
    }

    @RequestMapping("/save")
    @ResponseBody
    public User saveUser (@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @RequestMapping("/get")
    @ResponseBody
    public User getUser (Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/find")
    @ResponseBody
    public List<User> findUser (String userName, String note, Integer skip, Integer limit) {
        List<User> userList = userService.findUser(userName, note, skip, limit);
        return userList;
    }

    @RequestMapping("/update")
    @ResponseBody
    public UpdateResult updateUser (Long id, String userName, String note) {
        return userService.updateUser(id, userName, note);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public DeleteResult deleteUser (Long id) {
        return userService.deleteUser(id);
    }

}
