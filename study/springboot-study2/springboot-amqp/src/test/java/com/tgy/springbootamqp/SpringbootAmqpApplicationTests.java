package com.tgy.springbootamqp;

import com.tgy.springbootamqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAmqpApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        //message 需要自己构造一个；定制消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitMQ
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String,Object> map=new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象默认序列化后发送出去
        //rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("西游记","吴承恩"));

    }

    /**
     * 接收数据，如何将数据自动的转为json发送出去(自定义MessageConverter ，实现接口 返回 new Jackson2JsonMessageConverter() 即可)
     */
    @Test
    public void receiveMsg(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //广播
    @Test
    public void sendMsg(){
       rabbitTemplate.convertAndSend("exchange.fanout","",new Book("三国演义","罗贯中"));
    }
}
