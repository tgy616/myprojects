package com.tgy.springbootsecure.controllor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.header.writers.frameoptions.AllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DragonSwimDiving
 * @program springbootsecure
 * @Date 2019-05-27 16:10
 **/
@Configuration
public class WebSecurituConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //CSRF
        http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository()).requireCsrfProtectionMatcher(
                httpServletRequest -> httpServletRequest.getMethod().equals("POST") && httpServletRequest.getRequestURI().startsWith("/login")
        );

        //CSP
        http.headers().contentSecurityPolicy("script-src https://code.jquery.com/");
        // X-Frame-Options header
        // 相同域名是允许的
        // http.headers().frameOptions().sameOrigin();

        //实现绝对允许(实现白名单方式)
        http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new AllowFromStrategy() {
            @Override
            public String getAllowFromValue(HttpServletRequest request) {
                return "http://myzuul.com";
            }
        }));


        // XSS header
        http.headers().xssProtection().block(true);

        //授权
        http.authorizeRequests().anyRequest().fullyAuthenticated()
                 .and().
                formLogin().usernameParameter("name") // 用户名参数
                .passwordParameter("pwd") // 密码参数
                .loginProcessingUrl("/loginAction") // 登录 Action 的 URI
                .loginPage("/login") // 登录页面 URI
                .failureForwardUrl("/error") // 登录失败后的页面URI
                .permitAll()
                .and().logout().permitAll();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("tgy").password("123456").roles("ADMIN").
        and().withUser("刘德华").password("123456").roles("USER");
    }
}
