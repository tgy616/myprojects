package com.tgy.cache.service;

import com.tgy.cache.bean.Department;
import com.tgy.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/7/6
 */
@Service
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManger")
    @Autowired
    RedisCacheManager deptCacheManger;

//    @Cacheable(value = "dept",cacheManager = "deptCacheManger")
//    public Department getDept(Integer id){
//        System.out.println("查询部门:"+id);
//        Department department=departmentMapper.getDeptById(id);
//        return department;
//    }

    @Cacheable(value = "dept",cacheManager = "deptCacheManger")
    public Department getDept(Integer id){
        System.out.println("查询部门:"+id);
        Department department=departmentMapper.getDeptById(id);
        //获取某个缓存
        Cache dept = deptCacheManger.getCache("dept");
        dept.put("dept:1",department);

        return department;
    }

}
