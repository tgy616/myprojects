package com.tgy.springbootcache.repository;

import com.tgy.springbootcache.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link PersonRepository} 实现
 *
 * @see
 * @since 2017.08.04
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final Map<String, Person> repository = new HashMap<>();

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Person findPerson(String id) {
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public boolean savePerson(Person person) {
        redisTemplate.opsForValue().set(person.getId(), person);
//        return repository.putIfAbsent(person.getId(), person) == null;
        return true;
    }

}
