package com.tgy.springbootmybatis.demo;

import com.tgy.springbootmybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * @author tanggy
 * @date 2018/5/28
 */
public class MyBatisConfigrationDemo {


    public static void main(String[] args) throws IOException {
        ResourceLoader resourceLoader=new DefaultResourceLoader();
        Resource resource=resourceLoader.getResource("mybatis/mybatis-config.xml");
        EncodedResource encodedResource=new EncodedResource(resource,"UTF-8");
        Reader reader=encodedResource.getReader();
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=builder.build(reader,"dev",new Properties());
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user=sqlSession.selectOne("selectOneUser",101);
        System.out.println(user.toString());

        sqlSession.close();
    }

}
