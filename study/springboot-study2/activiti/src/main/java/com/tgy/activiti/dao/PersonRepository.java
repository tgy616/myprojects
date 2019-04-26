package com.tgy.activiti.dao;

import com.tgy.activiti.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author tanggy
 * @date 2018/9/21
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    public Person findByPersonName(String personName);

}
