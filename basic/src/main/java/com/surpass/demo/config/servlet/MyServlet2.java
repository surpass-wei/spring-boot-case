package com.surpass.demo.config.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义Servlet（已通过@WebServlet注解注册，只需在Application类开启@ServletComponentScan即可）
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/24.
 */
@WebServlet(urlPatterns = "/myServlet2/*", description = "说明")
public class MyServlet2 extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(MyServlet2.class);

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
        out.println("<h1>这是：MyServlet2</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
