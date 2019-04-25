package com.tgy.springbootcache.repository;

import com.tgy.springbootcache.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 人员 仓库
 *
 * @see
 * @since 2017.08.04
 */
@NoRepositoryBean
public interface PersonRepository {


    @Cacheable(cacheNames = "persons")
    Person findPerson(String id);


//    @CachePut(cacheNames = "persons")
    boolean savePerson(Person person);


}
