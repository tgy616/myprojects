package com.tgy.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.xml.DOMConfigurator;

import java.net.URL;

import static org.apache.log4j.LogManager.DEFAULT_CONFIGURATION_KEY;

/**
 * log4j test
 *
 * @author DragonSwimDiving
 * @program log4j
 * @Date 2019-05-31 15:41
 **/

public class Log4jTest {

    public static void main(String[] args) throws Exception {
        System.setProperty(DEFAULT_CONFIGURATION_KEY, "log4j-conf.xml");

        Logger logger = Logger.getLogger(Log4jTest.class.getName());

        logger.setLevel(Level.INFO);

        logger.info("Hello,World");

        // 重新加载 log4j的配置

        URL url = Thread.currentThread().getContextClassLoader().getResource("log4j-api.xml");

        DOMConfigurator.configure(url);

        MDC.put("requestURI","https://tgy.com");

        logger = Logger.getLogger(Log4jTest.class.getName());

        // 调整级别后输出
        logger.info("Hello,World");

        logger.error("大家好");
    }
}
