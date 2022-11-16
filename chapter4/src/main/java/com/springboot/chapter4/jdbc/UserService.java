package com.springboot.chapter4.jdbc;

import com.mysql.cj.jdbc.Driver;
import com.springboot.chapter4.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter4.jdbc
 * @className : UserService
 * @description : TODO
 * @date : 2022/11/16 19:12
 */
public class UserService {

    public int insertUser () {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUserName("user_name_1");
        user.setNote("note_1");
        Connection connection = null;
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/chapter4",
                    "root",
                    "10142556"
            );
            connection.setAutoCommit(false);
            result = userDao.insertUser(connection, user);
            connection.commit();

        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }

}
