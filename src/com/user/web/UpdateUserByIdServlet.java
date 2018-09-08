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
 * @date 2018/9/7 20:16
 */
@WebServlet(urlPatterns = "/updateUserByIdServlet")
public class UpdateUserByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取数据
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        //处理数据
        User user = new User(Integer.parseInt(id), name, sex, Integer.parseInt(age), address, qq, email);
        UserService userService = new UserService();
        boolean isUpdate = userService.updateUserById(user);
        if (isUpdate) {
            //修改成功，查询所有用户信息
            response.sendRedirect("/pageQueryServlet?pageNum=" + pageNum + "&pageSize=" + pageSize);
        } else {
            //修改失败
            request.setAttribute("errorMsg", "修改用户信息失败");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
