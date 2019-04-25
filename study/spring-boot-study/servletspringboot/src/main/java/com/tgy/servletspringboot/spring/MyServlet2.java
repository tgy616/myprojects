package com.tgy.servletspringboot.spring;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author tanggy
 * @date 2018/5/21
 */
@WebServlet(
        name="myServlet2",
        urlPatterns = "/myservlet2",
        initParams = {@WebInitParam(name="myname",value="myvalue")}
)
public class MyServlet2 extends HttpServlet {
    private String value;
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        value=servletConfig.getInitParameter("myname");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {

        Writer writer=response.getWriter();
        ServletContext servletContext=getServletContext();
        servletContext.log("myservlet2 doGet...");
        writer.write("<html><body>hello springboot-servlet!!! my vlaue=:"+value+"</body></html>");

    }
}
