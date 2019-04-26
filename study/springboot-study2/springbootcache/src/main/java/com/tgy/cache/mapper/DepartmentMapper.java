package com.tgy.cache.mapper;

import com.tgy.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author tanggy
 * @date 2018/6/29
 */
@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM department WHERE id=#{id}")
    Department getDeptById(Integer id);
}
