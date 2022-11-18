package com.springboot.chapter6.service.impl;

import com.springboot.chapter6.service.JdbcService;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter6.service.impl
 * @className : JdbcServiceImpl
 * @description : TODO
 * @date : 2022/11/18 14:24
 */
@Service
public class JdbcServiceImpl implements JdbcService {

    @Autowired
    private DataSource dataSource = null;

    @Override
    public int insertUser(String userName, String note) {
        Connection connection = null;
        int result = 0;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(TransactionIsolationLevel.READ_COMMITTED.getLevel());
            PreparedStatement ps = connection.prepareStatement(
                    "insert into t_user (user_name, note) values (?, ?)");
            ps.setString(1, userName);
            ps.setString(2, note);
            result = ps.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }
}
