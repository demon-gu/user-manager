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
 * @date 2018/9/8 20:23
 */
@WebServlet(urlPatterns = "/pageQueryServlet")
public class PageQueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strPageNum = request.getParameter("pageNum");
        String strPageSize = request.getParameter("pageSize");
        UserService userService = new UserService();
        //当前页的页数
        int pageNum = Integer.parseInt(strPageNum);
        //每页显示的个数
        int pageSize = Integer.parseInt(strPageSize);
        //每页的起始条目索引
        int startCount = (pageNum - 1) * pageSize;
        List<User> pageUsers = userService.pageQuery(startCount, pageSize);

        int totalItemCount = userService.queryTotalItemCount(pageSize);
        int totalPageCount;
        //计算总页数
        if (totalItemCount % pageSize == 0) {
            totalPageCount = totalItemCount % pageSize;
        } else {
            totalPageCount = totalItemCount / pageSize + 1;
        }

        if (pageUsers != null) {
            //查询成功
            request.setAttribute("pageUsers", pageUsers);
            request.setAttribute("pageNum", pageNum);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("totalPageCount", totalPageCount);
            request.setAttribute("totalItemCount", totalItemCount);
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        }
    }
}
