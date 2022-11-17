package com.springboot.chapter5.controller;

import com.springboot.chapter5.pojo.User2;
import com.springboot.chapter5.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter5.controller
 * @className : MyBatisController
 * @description : TODO
 * @date : 2022/11/17 16:26
 */
@Controller
@RequestMapping("mybatis")
public class MyBatisController {

    @Autowired
    MyBatisUserService myBatisUserService = null;

    @ResponseBody
    @RequestMapping("/getUser")
    public User2 getUser(Long id) {
        return myBatisUserService.getUser(id);
    }

}
