package com.springboot.chapter7.controller;

import com.springboot.chapter7.pojo.User;
import com.springboot.chapter7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter7.controller
 * @className : UserController
 * @description : TODO
 * @date : 2022/11/21 22:27
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public Map<String, Object> getUser (Long id) {
        User user = userService.getUser(id);
        boolean flag = (user != null);
        String message = flag ? "查询成功" : "查询失败";
        return resultMap(flag, message, user);
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public Map<String, Object> insertUser (String userName, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);
        user = userService.insertUser(user);
        boolean flag = (user != null);
        String message = flag ? "更新成功" : "更新失败";
        return resultMap(flag, message, user);
    }

    @RequestMapping("/findUsers")
    @ResponseBody
    public Map<String, Object> findUsers (String userName, String note) {
        List<User> users = userService.findUsers(userName, note);
        boolean flag = (users != null);
        String message = flag ? "查询成功" : "查询失败";
        return resultMap(flag, message, users);
    }

    @RequestMapping("/updateUserName")
    @ResponseBody
    public Map<String, Object> updateUserName (Long id, String userName) {
        User user = userService.updateUserName(id, userName);
        boolean flag = (user != null);
        String message = flag ? "更新成功" : "更新失败";
        return resultMap(flag, message);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public Map<String, Object> deleteUser (Long id) {
        int result = userService.deleteUser(id);
        boolean flag = (result == 1);
        String message = flag ? "删除成功" : "删除失败";
        return resultMap(flag, message);
    }

    private Map<String, Object> resultMap (boolean success, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        result.put("message", message);
        return result;
    }

    private Map<String, Object> resultMap (boolean success, String message, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", success);
        result.put("message", message);
        result.put("data", data);
        return result;
    }

}
