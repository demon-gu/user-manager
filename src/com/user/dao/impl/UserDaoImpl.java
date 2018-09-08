package com.user.dao.impl;

import com.user.bean.Admin;
import com.user.bean.User;
import com.user.dao.UserDao;
import com.user.utils.JdbcTemplateUtil;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * TODO
 *
 * @author Demon
 * @date 2018/9/7 19:38
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = JdbcTemplateUtil.getJdbcTemplate();

    @Override
    public List<Admin> login(String username, String password) {
        JdbcTemplate template = JdbcTemplateUtil.getAdminJdbcTemplate();
        String sql = "select * from t_admin where username = ? and password = ? and isDelete = 0";
        List<Admin> admins = template.query(sql, new BeanPropertyRowMapper<>(Admin.class), username, password);
        return admins;
    }

    @Override
    public int register(Admin admin) {
        JdbcTemplate template = JdbcTemplateUtil.getAdminJdbcTemplate();
        String sql = "insert into t_admin values(null, ?, ?, 0)";
        int rows = template.update(sql, admin.getUsername(), admin.getPassword());
        return rows;
    }

    @Override
    public int queryTotalItemCount() {
        String sql = "select count(*) from t_user where isDelete = 0";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<User> pageQuery(int startCount, int pageSize) {
        String sql = "select * from t_user where isDelete = 0 limit ?,?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), startCount, pageSize);
    }

    @Override
    public List<User> queryAllUser() {
        String sql = "select * from t_user where isDelete = 0";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public int deleteUserById(String id) {
        String sql = "update t_user set isDelete = 1 where id = ?";
        int rows = jdbcTemplate.update(sql, id);
        return rows;
    }

    @Override
    public User queryUserById(String id) {
        String sql = "select * from t_user where id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int updateUserById(User user) {
        String sql = "update t_user set name = ?, sex = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        int rows = jdbcTemplate.update(sql, user.getName(), user.getSex(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
        return rows;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into t_user values(null,?,?,?,?,?,?,0)";
        int rows = jdbcTemplate.update(sql, user.getName(), user.getSex(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return rows;
    }
}
