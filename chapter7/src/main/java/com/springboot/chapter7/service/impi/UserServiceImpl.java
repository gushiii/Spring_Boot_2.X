package com.springboot.chapter7.service.impi;

import com.springboot.chapter7.dao.UserDao;
import com.springboot.chapter7.pojo.User;
import com.springboot.chapter7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter7.service.impi
 * @className : UserServiceImpl
 * @description : TODO
 * @date : 2022/11/21 22:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    @Cacheable(value = "redisCache", key = "'redis_user_'+#id")
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    @CachePut(value = "redisCache", key = "'redis_user_'+#id")
    public User insertUser(User user) {
        userDao.insertUser(user);
        return user;
    }

    @Override
    @Transactional
    @CachePut(value = "redisCache", key = "'redis_user_'+#id", condition = "#result != 'null'")
    public User updateUserName(Long id, String userName) {
        User user = this.getUser(id);
        if (user == null) {
            return null;
        }
        user.setUserName(userName);
        userDao.updateUser(user);
        return user;
    }

    @Override
    @Transactional
    public List<User> findUsers(String userName, String note) {
        return userDao.findUsers(userName, note);
    }

    @Override
    @Transactional
    @CacheEvict(value = "redisCache", key = "'redis_user_'+#id", beforeInvocation = false)
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
