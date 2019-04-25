package com.tgy.springbootmybatis.demo;

import com.tgy.springbootmybatis.entity2.User;
import com.tgy.springbootmybatis.entity2.UserExample;
import com.tgy.springbootmybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;
import java.util.List;

/**
 * @author tanggy
 * @date 2018/5/28
 */
public class MyBatisGenerateDemo {


    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("mybatis/mybatis-config.xml");
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(reader, "dev", new Properties());
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(103);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        System.out.println(user.toString());
        sqlSession.close();
    }

}
