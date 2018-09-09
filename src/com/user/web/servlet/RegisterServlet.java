package com.user.web.servlet;

import com.user.bean.Admin;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author Demon
 * @date 2018/9/8 10:22
 */
@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String affirmPassword = request.getParameter("affirmPassword");
        if (!password.equals(affirmPassword)) {
            //确认密码和密码不同
            request.setAttribute("errorMsg", "两次输入的密码不同！");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        UserService userService = new UserService();
        boolean isRegister = userService.register(admin);
        if (isRegister) {
            //注册成功
            response.sendRedirect("/index.jsp");
        } else {
            //注册失败
            request.setAttribute("errorMsg", "注册失败！");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
