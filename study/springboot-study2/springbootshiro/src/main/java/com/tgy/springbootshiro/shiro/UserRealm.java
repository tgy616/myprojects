package com.tgy.springbootshiro.shiro;

import com.tgy.springbootshiro.domain.User;
import com.tgy.springbootshiro.sevive.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tanggy
 * @date 2018/6/22
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        //info.addStringPermission("user:add");
        //获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        User user=(User)subject.getPrincipal();
        User dbUser = userService.findById(user.getId());
        info.addStringPermission(dbUser.getPerms());

        return info;
    }

    /**
     * 执行认证逻辑
     *
     * @param act
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken act) throws AuthenticationException {
        System.out.println("执行认证逻辑");
//        String name = "test";
//        String password = "123456";

        //编写shori判断逻辑，判断用户名密码
        //1、判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) act;
        User user = userService.findByName(token.getUsername());
        //if (!token.getUsername().equals(name)){
        if (user==null){
            return null;//shori底层会抛出AuthenticationException
        }
        //2、判断密码
        //return new SimpleAuthenticationInfo("",password,"");
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
