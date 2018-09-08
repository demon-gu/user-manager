package com.user.service;

import com.user.bean.Admin;
import com.user.bean.User;
import com.user.dao.UserDao;
import com.user.dao.impl.UserDaoImpl;

import java.util.List;

/**
 * TODO
 *
 * @author Demon
 * @date 2018/9/7 10:00
 */
public class UserService {
    private UserDao dao = new UserDaoImpl();
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> queryAllUser() {
        return dao.queryAllUser();
    }

    /**
     * 根据ID逻辑删除用户
     * @param id
     * @return
     */
    public boolean deleteUserById(String id) {
        int rows = dao.deleteUserById(id);
        return rows > 0;
    }

    /**
     * 根据ID获取用户信息
     * @param id
     * @return
     */
    public User queryUserById(String id) {
        return dao.queryUserById(id);
    }

    /**
     * 根据ID修改用户信息
     * @param user
     * @return
     */
    public boolean updateUserById(User user) {
        int rows = dao.updateUserById(user);
        return rows > 0;
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    public boolean addUser(User user) {
        int rows = dao.addUser(user);
        return rows > 0;
    }

    /**
     * 管理员登陆页面
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        List<Admin> admins = dao.login(username, password);
        return admins != null && admins.size() > 0;
    }

    public boolean register(Admin admin) {
        int rows = dao.register(admin);
        return rows > 0;
    }

    /**
     * 分页查询
     * @param startCount
     * @param pageSize
     * @return
     */
    public List<User> pageQuery(int startCount, int pageSize) {
        List<User> pageUsers = dao.pageQuery(startCount, pageSize);
        if (pageUsers != null && pageUsers.size() > 0) {
            return pageUsers;
        }
        return null;
    }

    /**
     * 查询数据库的条目数
     * @param pageSize
     * @return
     */
    public int queryTotalItemCount(int pageSize) {
        return dao.queryTotalItemCount();
    }
}
