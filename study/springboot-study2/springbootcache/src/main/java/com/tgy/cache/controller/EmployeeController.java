package com.tgy.cache.controller;

import com.tgy.cache.bean.Employee;
import com.tgy.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanggy
 * @date 2018/6/29
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
   @GetMapping("/emp/{id}")
   public Employee getEmp(@PathVariable("id") Integer id){
      return employeeService.getEmp(id);
   }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }
    @GetMapping("/delemp")
    public String deleteEmp(Integer id){
       employeeService.deleteEmp(id);
       return "success";
    }

    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmp(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }
}
