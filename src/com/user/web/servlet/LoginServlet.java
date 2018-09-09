package com.user.web.servlet;

import com.user.bean.Admin;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * TODO
 *
 * @author Demon
 * @date 2018/9/8 9:19
 */
@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        boolean isLogin = userService.login(username, password);
        HttpSession session = request.getSession();
        String remember = request.getParameter("remember");
        Admin admin = new Admin();
        if ("rememberMe".equals(remember) && isLogin) {
            admin.setUsername(username);
            admin.setPassword(password);
            session.setAttribute("admin", admin);
        } else if (!"rememberMe".equals(remember)){
            admin.setUsername(username);
            admin.setPassword("");
            session.setAttribute("admin", admin);
        }

        if (isLogin) {
            //登陆成功
            response.sendRedirect("/pageQueryServlet?pageNum=1&pageSize=5");
        } else {
            //登陆失败
            request.setAttribute("errorMsg", "用户名或密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
