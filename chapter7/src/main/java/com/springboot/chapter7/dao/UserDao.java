package com.springboot.chapter7.dao;

import com.springboot.chapter7.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter7.dao
 * @className : UserDao
 * @description : TODO
 * @date : 2022/11/21 21:57
 */
@Repository
public interface UserDao {

    User getUser (Long id);

    int insertUser (User user);

    int updateUser (User user);

    List<User> findUsers(@Param("userName") String userName,
                         @Param("note") String note);

    int deleteUser (Long id);

}
