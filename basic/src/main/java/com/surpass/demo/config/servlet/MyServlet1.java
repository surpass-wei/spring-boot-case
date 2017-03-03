package com.surpass.demo.config.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义Servlet（需要通过代码注册的方式注册该Servlet）
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
public class MyServlet1 extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(MyServlet1.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("已执行：MyServlet1.doGet()");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("已执行：MyServlet1.doPost()");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8"); //  设置编码，解决中文乱码问题

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>这是：MyServlet1</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
