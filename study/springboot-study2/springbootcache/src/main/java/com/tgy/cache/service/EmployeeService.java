package com.tgy.cache.service;

import com.tgy.cache.bean.Employee;
import com.tgy.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/6/29
 */
@CacheConfig(cacheNames = "emp",cacheManager = "empCacheManger")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存，以后再要相同的数据直接从缓存中取，不用调用该方法
     * CacheManager管理多个Cache组件的，对缓存的真正CURD操作在cache组件中，每一个缓存有自己唯一个名字
     * 几个属性
     *   CacheName/value ：指定缓存的名字,将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存
     *   key:缓存数据使用的key 可以用它來指定 默认是使用方法参数的值 1- 方法的返回值
     *          编写SpEL #id :参数id的值 #a0 #p0 #root.arg[0]
     *   keyGenerator :key的生成器 ，可以自己指定key的生成器的组件id
     *      key/keyGenerator 二选一使用
     *   cacheManager 指定缓存管理器，或者cacheResolver指定缓存解析器
     *   condition ：指定符合条件情况下才缓存
     *          condition="#id>0"
     *          condition = "#a0>1" : 第一个参数的值>1的时候才进行缓存
     *   unless：否定缓存 当unless指定的条件为true， 方法的返回值不会被缓存 可以获取到结果进行判断、
     *         ag: unless="#result==null"
     *         unless = "#a0==2" :如果第一个参数的值是2，结果不缓存
     *   sync:是否使用异步模式
     *
     *  原理：
     *      1、自动配置类 CacheAutoConfiguration
     *      2、缓存的配置类
     *      org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration
     *      org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *      3、哪个配置类默认生效 SimpleCacheConfiguration
     *      4、给容器中注册了一个 CacheManager:ConcurrentMapCacheManager
     *      5、可以获取和创建ConcurrentMapCache类型的缓存组件，他的作用将数据保存在ConcurrentMap中
     *
     *      运行的流程：
     *      Cacheable
     *      1、方法运行之前，先去查询Cache（缓存组件），按照cacheName指定的名字获取：（CacheManager
     *      先获取相应的缓存），第一次获取缓存如果没有cache组件会自动创建
     *      2、去Cache中查找缓存的内容，使用一个key:默认就是方法的参数：key是按照某种策略生成的；默认是
     *      使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key
     *      SimpleKeyGenerator生成key的默认策略：
     *          如果没有参数：key= new SimpleKey();
     *          如果有一个参数：key=参数的值
     *          如果有多个参数：key=SimpleKey(params);
     *      3、没有查到缓存就调用目标方法
     *      4、将目标方法返回的结果，放进缓存中
     *
     *      @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存，
     *      如果没有就运行方法并将结果放入缓存,以后再来调用就可以直接使用缓存中的数据；
     *
     *      核心：
     *          1）、使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMap】组件
     *          2)、key使用keyGenerator生成的，默认是SimpleKeyGenerator
     *
     * @param id
     * @return
     */
    @Cacheable(value = {"emp"}/*,keyGenerator="myKeyGenerator",condition = "#a0>1",unless = "#a0==2"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee employee = employeeMapper.getEmployeeById(id);
        return employee;
    }


    /**
     * @CachePut:既调用方法，又更新缓存数据；同步跟新缓存
     * 修改了数据库的某个数据，同时更新缓存；
     * 运行时机：
     * 1、先调用目标方法
     * 2、将目标方法的结果缓存起来
     *
     * 测试步骤：
     * 1、查询1号员工,查询结果会放在缓存中：
     *      key:1 value: lastName 李白
     * 2、以后查询还是之前的结果
     * 3、更新1号员工【lastName=zhagnshanfeng gender=0】
     *        将方法的返回值也放入缓存中了 ；
     *        Key:传入的employee对象 值：返回的employee对象；
     * 4、查询1号员工？
     *      应该是更新后的员工；
     *          key="#employee.id":使用传入的参数的员工id;
     *          key="#result.id";使用返回后的id
     *              @Cacheable 的key是不能用#result的
     *      为什么是没更新前的？【1号员工没在缓存中更新】
     */
    @CachePut(/*value = "emp",*/key="#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp"+employee);
        employeeMapper.updateEmp(employee);
        return  employee;
    }
    /**
     * @CacheEvict：缓存清除
     *  key：指定清除的数据
     *  allEntries = true :指定清除缓存中的所有数据
     *  beforeInvocation = =false :缓存的清除是否在方法的执行之前执行
     *      默认代表缓存清除是在方法执行之后执行的；如果出现异常，缓存就不会清除
     */
    @CacheEvict(/*value = "emp"*//*,key = "#id",allEntries = true*/)
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp：id" + id);
        //employeeMapper.deleteEmpById(id);
        int i=10/0;
    }

    @Caching(
            cacheable = {
                    @Cacheable(value="emp",key = "#lastName")
            },
            put = {
                    @CachePut(value = "emp",key="#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){

       return employeeMapper.getEmployeeByLastName(lastName);
    }

}
