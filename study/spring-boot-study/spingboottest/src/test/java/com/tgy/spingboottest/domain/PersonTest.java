package com.tgy.spingboottest.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DragonSwimDiving
 * @program spingboottest
 * @Date 2019-06-12 16:22
 **/

public class PersonTest {
    @Test
    public void testPerson(){
        Person person=new Person();
        person.setAge(10);
        Assert.assertEquals(Integer.valueOf(10),person.getAge());
        Assert.assertNotNull(person);

    }
}
