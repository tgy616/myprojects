package com.tgy.springbootjpa.repository;

import com.tgy.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tanggy
 * @date 2018/6/27
 */
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {

}