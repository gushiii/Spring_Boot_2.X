package com.springboot.chapter4.jdbc;

import com.springboot.chapter4.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.jdbc
 * @className : UserDao
 * @description : TODO
 * @date : 2022/11/16 19:12
 */
public class UserDao {

    public int insertUser (Connection connection, User user) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("insert into t_user(user_name, note) values (?, ?)");
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getNote());
            return ps.executeUpdate();
        } finally {
            ps.close();
        }
    }

}
