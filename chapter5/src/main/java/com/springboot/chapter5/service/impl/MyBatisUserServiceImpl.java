package com.springboot.chapter5.service.impl;

import com.springboot.chapter5.dao.MyBatisUserDao;
import com.springboot.chapter5.pojo.User2;
import com.springboot.chapter5.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter5.service.impl
 * @className : MyBatisUserServiceImpl
 * @description : TODO
 * @date : 2022/11/17 16:24
 */
@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {
    
    @Autowired
    MyBatisUserDao myBatisUserDao = null;
    
    @Override
    public User2 getUser(Long id) {
        User2 user = myBatisUserDao.getUser(id);
        return myBatisUserDao.getUser(id);
    }
}
