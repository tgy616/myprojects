package com.tgy.servletspringboot;

import com.tgy.servletspringboot.servlet.MyServletRequestListener;
import com.tgy.servletspringboot.spring.MyFilter2;
import com.tgy.servletspringboot.spring.MyServlet2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.tgy.servletspringboot.servlet","com.tgy.servletspringboot.spring"})
public class ServletspringbootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ServletspringbootApplication.class, args);
    }

    @Bean
    public static ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new MyServlet2());
        servletRegistrationBean.setName("my-servlet2");
        servletRegistrationBean.addUrlMappings("/spring-boot/myservlet2");
        servletRegistrationBean.addInitParameter("myname","myvalue");

        return servletRegistrationBean;
    }

    @Bean
    public static FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter2());
        filterRegistrationBean.setName("my-servlet2");
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE);

        return filterRegistrationBean;
    }
    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean=new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new MyServletRequestListener());
        return servletListenerRegistrationBean;
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(ServletspringbootApplication.class);
        return builder;
    }
}
