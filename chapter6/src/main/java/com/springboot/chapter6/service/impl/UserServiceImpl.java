package com.springboot.chapter6.service.impl;

import com.springboot.chapter6.dao.UserDao;
import com.springboot.chapter6.pojo.User;
import com.springboot.chapter6.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class UserServiceImpl implements UserService, ApplicationContextAware {

    @Autowired
    UserDao userDao = null;

    private ApplicationContext applicationContext = null;

    @Override
    public int insertUsers(List<User> userList) {
        int count = 0;
        UserService userService = applicationContext.getBean(UserService.class);
        for (User user : userList) {
            count += userService.insertUser(user);
        }
        return count;
    }
    @Override
    @Transactional(
//            isolation = Isolation.SERIALIZABLE, timeout = 1,
//            propagation = Propagation.REQUIRED
//            propagation = Propagation.NESTED
            isolation = Isolation.READ_COMMITTED, timeout = 1,
            propagation = Propagation.REQUIRES_NEW
    )
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
