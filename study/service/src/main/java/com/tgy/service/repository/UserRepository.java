package com.tgy.service.repository;

import com.tgy.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author tanggy
 * @date 2018/11/28
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
