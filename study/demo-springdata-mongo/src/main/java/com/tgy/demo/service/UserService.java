package com.tgy.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgy.demo.dao.IBaseDao;
import com.tgy.demo.dao.IUserDao;
import com.tgy.demo.entity.UserInfo;

/**
 * 用户service类
 * ClassName: UserService
 */
@Service
public class UserService extends BaseService<UserInfo> {

	@Autowired
	private IUserDao userDao;

	@Override
	protected IBaseDao<UserInfo> getDao() {
		return userDao;
	}

}