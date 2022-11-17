package com.springboot.chapter5.dao;

import com.springboot.chapter5.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {
}
