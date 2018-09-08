package com.user.web;

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
 * @date 2018/9/8 22:48
 */
@WebServlet(urlPatterns = "/addUserCheckoutServlet")
public class AddUserCheckoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("pageSize", pageSize);
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }
}
