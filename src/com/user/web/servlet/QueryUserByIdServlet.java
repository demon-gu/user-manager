package com.user.web.servlet;

import com.user.bean.User;
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
 * @date 2018/9/7 20:22
 */
@WebServlet(urlPatterns = "/queryUserByIdServlet")
public class QueryUserByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理修改用户信息之前的查询操作
        String id = request.getParameter("id");
        //根据ID获取用户信息
        UserService userService = new UserService();
        User userInfo = userService.queryUserById(id);
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        if (userInfo != null) {
            //查询成功
            request.setAttribute("user", userInfo);
            request.setAttribute("pageNum", pageNum);
            request.setAttribute("pageSize", pageSize);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMsg", "查询用户信息失败！");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
