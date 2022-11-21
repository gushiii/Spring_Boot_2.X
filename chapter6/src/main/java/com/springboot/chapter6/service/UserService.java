package com.springboot.chapter6.service;

import com.springboot.chapter6.pojo.User;

import java.util.List;

public interface UserService {

    public int insertUser (User user);
    public User getUser (Long id);

    public int insertUsers(List<User> userList);

}
