package com.springboot.chapter6.service.impl;

import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.UserBatchService;
import com.springboot.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter6.service.impl
 * @className : UserBatchServiceImpl
 * @description : TODO
 * @date : 2022/11/21 13:48
 */
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    UserService userService = null;

    @Override
    public int insertUser(List<User> userList) {
        int count = 0;
        for (User user : userList) {
            count += userService.insertUser(user);
        }
        return count;
    }
}
