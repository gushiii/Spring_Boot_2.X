package com.springboot.chapter4.aspect.validator;

import com.springboot.chapter4.pojo.User;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.aspect.validator
 * @className : UserValidator
 * @description : TODO
 * @date : 2022/11/16 20:27
 */
public interface UserValidator {
    public boolean validator (User user);
}
