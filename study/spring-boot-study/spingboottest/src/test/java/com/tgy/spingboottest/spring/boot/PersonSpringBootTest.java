package com.tgy.spingboottest.spring.boot;

import com.tgy.spingboottest.configuration.PersonConfiguration;
import com.tgy.spingboottest.domain.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see
 * @since 2017.09.13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersonConfiguration.class)
public class PersonSpringBootTest {

    @Autowired
    private Person person;

    @Test
    public void testPrimaryPerson() {

        Assert.assertEquals(Long.valueOf(1L), person.getId());
        Assert.assertEquals("小马哥", person.getName());
        Assert.assertEquals(Integer.valueOf(32), person.getAge());

    }

}
