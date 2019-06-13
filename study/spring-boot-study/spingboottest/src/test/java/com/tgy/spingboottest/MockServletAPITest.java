package com.tgy.spingboottest;

import org.junit.Test;
import org.springframework.mock.web.MockServletContext;

/**
 * Todo
 * @author DragonSwimDiving
 * @program spingboottest
 * @Date 2019-06-12 17:20
 **/

public class MockServletAPITest {
    @Test
    public void testMockServletContext(){
        //不支持 Servlet 3.0 的注册 API
        MockServletContext servletContext = new MockServletContext();
        servletContext.setInitParameter("abc","def");
    }
}
