package com.tgy.spingboottest;

import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.junit.Assert.*;
/**
 * TODO
 * @author DragonSwimDiving
 * @program spingboottest
 * @Date 2019-06-12 17:19
 **/

public class EnvironmentTest {

    @Test
    public void testSystemProperty() {
        assertNotNull(System.getProperty("os.arch"));
//        Environment environment = new StandardEnvironment();
//        Environment webEnvironment = new StandardServletEnvironment();
        MockEnvironment environment = new MockEnvironment();

        environment.setProperty("user.country", "EN");

        assertEquals("EN", environment.getProperty("user.country"));

    }

    @Test
    public void testManagementSecurityEnabled() {

        MockEnvironment environment = new MockEnvironment();

        environment.setProperty("management.security.enabled", "true");

        assertTrue(environment.getProperty("management.security.enabled", boolean.class));

    }

    @Test
    public void testManagementSecurityDisabled() {

        MockEnvironment environment = new MockEnvironment();

        environment.setProperty("management.security.enabled", "false");

        assertFalse(environment.getProperty("management.security.enabled", boolean.class));

    }
}
