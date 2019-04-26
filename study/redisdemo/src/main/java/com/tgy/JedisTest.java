package com.tgy;

import redis.clients.jedis.Jedis;

/**
 * @author tanggy
 * @date 2018/5/15
 */
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());
        jedis.set("name","test");//向key -->name 中放入了value--->test
        System.out.println(jedis.get("name"));

        jedis.append("name"," is my first jedis test");//拼接
        System.out.println(jedis.get("name"));

        jedis.del("name");//删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name","tgy","age","18","qq","4189892XXX");
        jedis.incr("age");//进行加1操作
        System.out.println(jedis.get("name")+"-"+jedis.get("age")+"-"+jedis.get("qq"));

    }
}
