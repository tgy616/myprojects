
package com.tgy.springboot4jsp.dao;

import com.tgy.springboot4jsp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

}
