package com.springboot.chapter3.controller;

import com.springboot.chapter3.pojo.DataBaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter3.controller
 * @className : TestController
 * @description : TODO
 * @date : 2022/11/15 23:11
 */
@Controller
public class TestController {

    @Autowired
    DataBaseProperties dataBaseProperties;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test () {
        return dataBaseProperties.toString();
    }

}
