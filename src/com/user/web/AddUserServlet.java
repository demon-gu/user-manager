package com.user.web;

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
 * @date 2018/9/7 21:05
 */
@WebServlet(urlPatterns = "/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取数据
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        //处理数据
        User user = new User(null, name, sex, Integer.parseInt(age), address, qq, email);
        UserService userService = new UserService();
        boolean isAdd = userService.addUser(user);
        if (isAdd) {
            //添加成功，需要查询所有用户信息
            response.sendRedirect("/pageQueryServlet?pageNum=" + pageNum + "&pageSize=" + pageSize);
        } else {
            //添加失败，跳转失败页面
            request.setAttribute("errorMsg", "添加用户信息失败！");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
