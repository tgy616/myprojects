package com.tgy.sbredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author tanggy
 * @date 2018/5/15
 */
@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key,String value){
        this.setObject(key,value,null);
    }
    public void setString(String key,String value,Long time){
        this.setObject(key,value,time);
    }
    public void setList(String key,List<String> listValue){
        this.setObject(key,listValue,null);
    }
    public void setList(String key,List<String> listValue,Long time){
            this.setObject(key,listValue,time);
        }


     public void setObject(String key,Object value,Long time){
         //redis可以存储的类型 string list set  zset hash
        if(StringUtils.isEmpty(key)||value==null){
            return;
        }
        //判断类型
         // 存放1、String
         if(value instanceof String){
            String strValue=(String)value;
             stringRedisTemplate.opsForValue().set(key,strValue);
             if(time!=null){
                 stringRedisTemplate.opsForValue().set(key,strValue,time,TimeUnit.SECONDS);
             }
             return;
         }

         //存放list
         if(value instanceof List){
            List<String> listValue=(List<String>) value;
             for (String string:listValue) {
                 stringRedisTemplate.opsForList().leftPush(key,string);
                /* if(time!=null){
                     stringRedisTemplate.opsForValue().set(key,string,time,TimeUnit.SECONDS);
                 }*/
             }
             return;
         }
         //set zset hash  自己补充

     }
     public String getStringKey(String key){
        return  stringRedisTemplate.opsForValue().get(key);
     }


}
