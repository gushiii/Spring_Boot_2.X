package com.springboot.chapter8.repository.impl;

import com.springboot.chapter8.pojo.User;
import com.springboot.chapter8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter8.repository.impl
 * @className : UserRepositoryImpl
 * @description : TODO
 * @date : 2022/11/22 15:35
 */
@Repository
public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTmpl = null;

    public User findUserByIdOrUserName (Long id, String userName) {
        Criteria criteriaId = Criteria.where("id").is(id);
        Criteria criteriaUserName = Criteria.where("userName").is(userName);
        Criteria criteria = new Criteria();
        criteria.orOperator(criteriaId, criteriaUserName);
        Query query = Query.query(criteria);
        return mongoTmpl.findOne(query, User.class);
    }

}
