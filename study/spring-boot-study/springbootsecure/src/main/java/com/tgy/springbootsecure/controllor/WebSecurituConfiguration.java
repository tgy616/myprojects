package com.tgy.springbootsecure.controllor;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author DragonSwimDiving
 * @program springbootsecure
 * @Date 2019-05-27 16:10
 **/
@Configuration
public class WebSecurituConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository()).requireCsrfProtectionMatcher(
                httpServletRequest -> httpServletRequest.getMethod().equals("POST") && httpServletRequest.getRequestURI().startsWith("/login")
        );
    }
}
