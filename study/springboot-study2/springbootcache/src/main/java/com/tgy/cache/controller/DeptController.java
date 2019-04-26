package com.tgy.cache.controller;

import com.tgy.cache.bean.Department;
import com.tgy.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2018/7/6
 */
@RestController
public class DeptController{
    @Autowired
    DeptService deptService;

    /**
     * 缓存的数据能存入redis
     * 第二次从缓存中查询，就不能反序列化回来，
     * 存的是dept的json数据；CacheManager默认使用RedisTemplate<Object, Employee>操作redis
     *
     * @param id
     * @return
     */
    @GetMapping("/dept/{id}")
    public Department getDetpt(@PathVariable("id") Integer id){
        Department dept = deptService.getDept(id);
        return dept;
    }

}
