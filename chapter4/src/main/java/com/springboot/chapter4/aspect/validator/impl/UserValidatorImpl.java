package com.springboot.chapter4.aspect.validator.impl;

import com.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.chapter4.pojo.User;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.aspect.validator.impl
 * @className : UserValidatorImpl
 * @description : TODO
 * @date : 2022/11/16 20:28
 */
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validator(User user) {
        System.out.println("引入新的接口 : " + UserValidator.class.getSimpleName());
        return user != null;
    }
}
