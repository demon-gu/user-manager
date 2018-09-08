package com.user.dao;

import com.user.bean.Admin;
import com.user.bean.User;

import java.util.List;

/**
 * TODO
 *
 * @author Demon
 * @date 2018/9/7 19:38
 */
public interface UserDao {
    List<User> queryAllUser();

    int deleteUserById(String id);

    User queryUserById(String id);

    int updateUserById(User user);

    int addUser(User user);

    List<Admin> login(String username, String password);

    int register(Admin admin);

    List<User> pageQuery(int startCount, int pageSize);

    int queryTotalItemCount();
}
