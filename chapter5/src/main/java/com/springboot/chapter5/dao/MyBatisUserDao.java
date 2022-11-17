package com.springboot.chapter5.dao;

import com.springboot.chapter5.pojo.User2;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBatisUserDao {

    User2 getUser (Long id);

}
