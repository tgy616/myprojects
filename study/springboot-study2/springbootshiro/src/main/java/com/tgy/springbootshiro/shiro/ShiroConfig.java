package com.tgy.springbootshiro.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tanggy
 * @date 2018/6/22
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
       //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**shiro添加内置过滤器，可以实现权限相关的设置
         *   常用的过滤器：
         *          anon:无需认证（登录）可以访问
         *          authc:必须认证才可以访问
         *          user:如果使用rememberMe的功能可以直接访问
         *          perms:该资源必须资源权限才可以访问
         *          role：该资源必须得到角色权限才可以访问
         */
        Map<String,String> filterMap=new LinkedHashMap<>();
        /*filterMap.put("/add","authc");
        filterMap.put("/update","authc");*/


        filterMap.put("/testThymeleaf","anon");//这个必须放到authc前，否则无法使用
        //放行login
        filterMap.put("/login","anon");

        //授权过滤器
        //注意：当授权拦截后，shiro会自动跳转到未授权页面

        filterMap.put("/add","perms[user:add]");
        filterMap.put("/update","perms[user:update]");

        filterMap.put("/*","authc");

        //修改调整登录的页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");

        return shiroFilterFactoryBean;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean("userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置shiroDialect,用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){

        return new ShiroDialect();
    }


}
