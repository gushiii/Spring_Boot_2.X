package com.springboot.chapter5.dao;

import com.springboot.chapter5.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<User, Long> {

    @Query("from user where userName like concat('%','?1','%') "
            + "and note like concat('%','?2','%')")
    List<User> findUsers (String userName, String note);

    List<User> findByUserNameLike(String userName);

    User getUserById(Long id);

    List<User> findByUserNameLikeOrNoteLike(String userName, String note);
}
