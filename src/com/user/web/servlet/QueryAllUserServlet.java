package com.user.web.servlet;

import com.user.bean.User;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * TODO
 *
 * @author Demon
 * @date 2018/9/7 9:59
 */
@WebServlet(urlPatterns = "/queryAllUserServlet")
public class QueryAllUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        List<User> users = userService.queryAllUser();
        request.setAttribute("userInfoList", users);

        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }
}
