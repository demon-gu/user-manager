package com.user.web;

import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        boolean isLogin = userService.login(username, password);
        Cookie usernameCookie = null;
        Cookie passwordCookie = null;
        String remember = request.getParameter("remember");
        if ("rememberMe".equals(remember) && isLogin) {
            usernameCookie = new Cookie("username", username);
            passwordCookie = new Cookie("password", password);
            usernameCookie.setMaxAge(60 * 60 * 24 * 365);
            passwordCookie.setMaxAge(60 * 60 * 24 * 365);
            usernameCookie.setPath("/");
            passwordCookie.setPath("/");
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        } else if (!"rememberMe".equals(remember)){
            usernameCookie = new Cookie("username", "");
            passwordCookie = new Cookie("password", "");
            usernameCookie.setMaxAge(60 * 60 * 24 * 365);
            passwordCookie.setMaxAge(60 * 60 * 24 * 365);
            usernameCookie.setPath("/");
            passwordCookie.setPath("/");
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
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
