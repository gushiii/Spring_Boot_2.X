package com.springboot.chapter3.service;

import com.springboot.chapter3.pojo.User3;
import org.springframework.stereotype.Service;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : chapter1
 * @package : com.springboot.chapter3.service
 * @className : UserService
 * @description : TODO
 * @date : 2022/11/15 17:51
 */
@Service
public class UserService {

    public void printUser (User3 user3) {
        System.out.println("id        : "+ user3.getId());
        System.out.println("user_name : "+ user3.getUserName());
        System.out.println("note      : "+ user3.getNote());
    }

}
