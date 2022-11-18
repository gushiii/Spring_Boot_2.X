package com.springboot.chapter6.service.impl;

import com.springboot.chapter6.dao.UserDao;
import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter6.service.impl
 * @className : UserServiceImpl
 * @description : TODO
 * @date : 2022/11/18 15:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
}
