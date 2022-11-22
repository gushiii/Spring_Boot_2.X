package com.springboot.chapter8.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.springboot.chapter8.pojo.User;
import com.springboot.chapter8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter8.service.impl
 * @className : UserServiceImpl
 * @description : TODO
 * @date : 2022/11/22 00:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTmpl = null;

    @Override
    public void saveUser(User user) {
        mongoTmpl.save(user, "user");
    }

    @Override
    public DeleteResult deleteUser(Long id) {
        Criteria criteriaId = Criteria.where("id").is(id);
        Query queryId = Query.query(criteriaId);
        DeleteResult result = mongoTmpl.remove(queryId, User.class);
        return result;
    }

    @Override
    public List<User> findUser(String userName, String note, int skip, int limit) {
        Criteria criteria = Criteria.where("userName").regex(userName)
                                      .and("note").regex(note);
        Query query = Query.query(criteria).skip(skip).limit(limit);
        List<User> userList = mongoTmpl.find(query, User.class);
        return userList;
    }

    @Override
    public UpdateResult updateUser(Long id, String userName, String note) {
        Criteria criteriaId = Criteria.where("id").is(id);
        Query query = Query.query(criteriaId);
        Update update = Update.update("userName", userName);
        update.set("note", note);
        UpdateResult result = mongoTmpl.updateFirst(query, update, User.class);
//        UpdateResult result = mongoTmpl.updateMulti(query, update, User.class);
        return result;
    }

    @Override
    public User getUser(Long id) {
        return mongoTmpl.findById(id, User.class);
//        Criteria criteriaId = Criteria.where("id").is(id);
//        Query queryId = Query.query(criteriaId);
//        return mongoTmpl.findOne(queryId, User.class);
    }
}
