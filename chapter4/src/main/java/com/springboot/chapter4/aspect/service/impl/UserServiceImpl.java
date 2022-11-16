package com.springboot.chapter4.aspect.service.impl;

import com.springboot.chapter4.aspect.service.UserService;
import com.springboot.chapter4.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.aspect.service.impl
 * @className : UserServiceImpl
 * @description : TODO
 * @date : 2022/11/16 19:35
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("检查用户参数是否为空 ... ");
        }
        System.out.println("id       : " + user.getId());
        System.out.println("username : " + user.getUserName());
        System.out.println("note     : " + user.getNote());
    }

    @Override
    public void manyAspects() {
        System.out.println("测试多个切面顺序");
    }
}
