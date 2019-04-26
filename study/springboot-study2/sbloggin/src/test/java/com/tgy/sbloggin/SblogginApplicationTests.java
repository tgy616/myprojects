package com.tgy.sbloggin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SblogginApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        logger.trace("这是trace日志。。。");
        logger.debug("this is debug log...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("this is info log...");
        logger.warn("this is warn  log...");
        logger.error("this is error log...");
    }

}
