package com.tgy.demo.dao.impl;

import com.tgy.demo.entity.UserInfo;
import org.springframework.stereotype.Repository;

import com.tgy.demo.dao.IUserDao;

/**
 * 用户接口实现类
 * ClassName: UserDaoImpl
 * @date 2017年4月12日
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<UserInfo> implements IUserDao {

	@Override
	protected Class<UserInfo> getEntityClass() {
		return UserInfo.class;
	}

}