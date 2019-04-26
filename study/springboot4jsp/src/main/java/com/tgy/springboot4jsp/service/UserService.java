
package com.tgy.springboot4jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void add(Integer id,String name, Integer age) {
		String insertUserSQL = "insert into users values(?,?,?);";
		jdbcTemplate.update(insertUserSQL,id, name, age);
		System.out.println("添加成功...");
	}

}
