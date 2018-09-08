package com.user.web;

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
 * @date 2018/9/7 19:47
 */
@WebServlet(urlPatterns = "/deleteUserByIdServlet")
public class DeleteUserByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        //获取数据
        String id = request.getParameter("id");
        //处理数据
        UserService userService = new UserService();
        boolean isDelete = userService.deleteUserById(id);
        if (isDelete) {
            //删除成功，需要查询所有用户信息
            response.sendRedirect("/pageQueryServlet?pageNum=" + pageNum + "&pageSize=" + pageSize);
        } else {
            //删除失败，跳到错误页面
            request.setAttribute("errorMsg", "删除用户信息失败");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
