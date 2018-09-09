package com.user.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 统一解决post请求和响应乱码问题
 *
 * @author Demon
 * @date 2018/9/9 12:09
 */
@WebFilter(urlPatterns = "/*")
public class AEncoderFilter implements Filter {

    private String encoding = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //处理请求和响应乱码
        if (encoding != null) {
            request.setCharacterEncoding(encoding);
            response.setContentType("text/html;charset=" + encoding);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        //全局的域对象
        ServletContext servletContext = config.getServletContext();
        //全局配置参数
        encoding = servletContext.getInitParameter("encoding");
    }

    @Override
    public void destroy() {
    }
}
