package com.tgy.cache;

import com.tgy.cache.bean.Employee;
import com.tgy.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootcacheApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v 都是字符串的
    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象的
    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;

    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmployeeById(1);
        System.out.println(employee);
    }

    /**
     * String (字符串)、list(列表)、Set(集合)、Hash(散列)、ZSet(有序集合)
     * stringRedisTemplate.opsForValue() [String (字符串)]
     * stringRedisTemplate.opsForList() [list(列表)]
     * stringRedisTemplate.opsForSet()   [Set(集合)]
     * stringRedisTemplate.opsForHash() [Hash(散列)]
     * stringRedisTemplate.opsForZSet() [ZSet(有序集合)]
     */
    @Test
    public void test01(){
        //给redis中保存数据
        //stringRedisTemplate.opsForValue().append("msg","hello");
        String s = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(s);
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
        stringRedisTemplate.opsForList().leftPush("mylist","3");
    }

    /**
     * 测试保存对象
     */
    @Test
    public void test2(){
        Employee empById = employeeMapper.getEmployeeById(2);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //redisTemplate.opsForValue().set("emp01",empById);
        //1、将数据以json的方式保存
        //（1）自己讲对象转换为json
        //（2）redisTemplate默认的序列化规则,改变默认的序列化规则
        empRedisTemplate.opsForValue().set("emp01",empById);
    }

}
