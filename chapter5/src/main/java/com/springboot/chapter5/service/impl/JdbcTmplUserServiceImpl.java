package com.springboot.chapter5.service.impl;

import com.springboot.chapter5.enumeraction.SexEnum;
import com.springboot.chapter5.pojo.User;
import com.springboot.chapter5.service.JdbcTmplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @author : GUSHIII
 * @version : 1.0
 * @projectName : Spring_Boot
 * @package : com.springboot.chapter5.service.impl
 * @className : JdbcTmplUserServiceImpl
 * @description : TODO
 * @date : 2022/11/17 10:26
 */
@Service
public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {

    @Autowired
    JdbcTemplate jdbcTemplate = null;

    private RowMapper<User> getUserMapper () {
        RowMapper<User> userRowMapper = (ResultSet rs, int rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            user.setNote(rs.getString("note"));
            int sexId = rs.getInt("sex");
            SexEnum sexEnum = SexEnum.getEnumById(sexId);
            user.setSex(sexEnum);
            return user;
        };
        return userRowMapper;
    }

    @Override
    public User getUser(Long id) {
        String sql = "SELECT id, user_name, sex, note FROM t_user WHERE id = ?";
        Object[] params = new Object[] {id};
        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
        return user;
    }

    public User getUser2(Long id) {
        User result = this.jdbcTemplate.execute((Statement stmt) -> {
            String sql1 = "SELECT COUNT(*) total FROM t_user WHERE id = " + id;
            ResultSet rs1 = stmt.executeQuery(sql1);
            while (rs1.next()) {
                int total = rs1.getInt("total");
                System.out.println(total);
            }

            String sql2 = "SELECT id, user_name, sex, note FROM t_user"
                                + " WHERE id = " + id;
            ResultSet rs2 = stmt.executeQuery(sql2);
            User user = null;
            while (rs2.next()) {
                int rowNum = rs1.getRow();
                user = getUserMapper().mapRow(rs2, rowNum);
            }
            return user;
        });
        return result;
    }

    public User getUser3(Long id) {
        User result = this.jdbcTemplate.execute((Connection connection) -> {
            String sql1 = "SELECT COUNT(*) as total FROM t_user WHERE id = ?";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setLong(1, id);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                System.out.println(rs1.getInt("total"));
            }

            String sql2 = "SELECT id, user_name, sex, note FROM t_user"
                    + " WHERE id = ?";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setLong(1, id);
            ResultSet rs2 = ps2.executeQuery(sql2);
            User user = null;
            while (rs2.next()) {
                int rowNum = rs1.getRow();
                user = getUserMapper().mapRow(rs2, rowNum);
            }
            return user;
        });
        return result;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = "SELECT id, user_name, sex, note FROM t_user "
                            + "WHERE user_name like concat('%', '?', '%')"
                            + "AND note like concat('%', '?', '%')";
        Object[] params = new Object[] {userName, note};
        List<User> userList = jdbcTemplate.query(sql, params, getUserMapper());
        return userList;
    }

    @Override
    public int insertUser(User user) {
        String sql = "INSERT INTO t_user (user_name, sex, note) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex(), user.getNote());
    }

    @Override
    public int updateUser(User user) {
        String sql = "UPDATE t_user SET user_name = ?, sex = ?, note = ?"
                            + "WHERE id = ?";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex(), user.getNote(), user.getId());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "DELETE FROM t_user WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
