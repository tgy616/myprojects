package com.xinwei.spring.boot.autoconfigure.shiro;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.xinwei.spring.boot.autoconfigure.shiro.annotation.SessionUserArgumentResolver;

import java.util.List;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@Configuration
public class ShiroWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SessionUserArgumentResolver());
    }

}
