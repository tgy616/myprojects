package com.tgy.beta.biz.service.impl;

import com.tgy.beta.biz.service.DemoService;
import com.tgy.beta.dao.entity.UserDO;
import com.tgy.beta.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DragonSwimDiving
 * @program beta
 * @Date 2019-07-02 10:02
 **/
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserMapper mapper;

    @Override
    public String test(Integer id) {
        UserDO user=mapper.selectByPrimaryKey(id);
        return user.toString();
    }
}
