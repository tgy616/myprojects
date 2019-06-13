package com.tgy.spingboottest;

import com.tgy.spingboottest.configuration.PersonConfiguration;
import com.tgy.spingboottest.domain.Person;
import com.tgy.spingboottest.listener.PersonIntegrationTestListener;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * @author DragonSwimDiving
 * @program spingboottest
 * @Date 2019-06-13 11:14
 **/
@RunWith(SpringRunner.class)
@ContextHierarchy(
        @ContextConfiguration(
                classes = PersonConfiguration.class
        )
)
@TestExecutionListeners(listeners = {
        PersonIntegrationTestListener.class,
        DependencyInjectionTestExecutionListener.class
})
@TestPropertySource(properties = {"name = 小马哥"})
public class PersonIntegrationTest {
    @Value("${name}")
    private String name;

    @Autowired
    private Person person;

    @BeforeClass
    public static void beforeClass() {
        System.err.println("beforeClass()");
    }

    @Before
    public void before() {
        System.err.println("before()");
    }

    @Test
    public void testPrimaryPerson() {

        Assert.assertEquals(Long.valueOf(1L), person.getId());
        Assert.assertEquals("小马哥", person.getName());
        Assert.assertEquals(Integer.valueOf(32), person.getAge());

    }

    @Test
    public void testName(){
        Assert.assertEquals("小马哥",name);
    }


    @After
    public void after() {
        System.err.println("after()");
    }

    @AfterClass
    public static void afterClass() {
        System.err.println("afterClass()");
    }
}
