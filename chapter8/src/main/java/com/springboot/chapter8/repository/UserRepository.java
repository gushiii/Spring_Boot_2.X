package com.springboot.chapter8.repository;

import com.springboot.chapter8.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter8.repository
 * @className : MongoRepository
 * @description : TODO
 * @date : 2022/11/22 15:20
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    List<User> findByUserNameLike (String userName);

    @Query("{'id': ?0, 'userName': ?1}")
    User find (Long id, String userName);

    User findUserByIdOrUserName (Long id, String userName);
}
