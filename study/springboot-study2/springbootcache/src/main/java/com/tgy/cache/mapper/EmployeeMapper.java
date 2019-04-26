package com.tgy.cache.mapper;

import com.tgy.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author tanggy
 * @date 2018/6/29
 */
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id=#{id}")
    public Employee getEmployeeById(Integer id);

    @Update("UPDATE employee Set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} " +
            " where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE employee where id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{d_id}) ")
    public void insertEmployee(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName=#{lastName}")
    public Employee getEmployeeByLastName(String lastName);
}
