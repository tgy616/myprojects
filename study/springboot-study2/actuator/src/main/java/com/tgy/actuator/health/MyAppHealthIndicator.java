package com.tgy.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author tanggy
 * @date 2018/10/9
 */
@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        //自定义的检查方法

        //Health.up().build();代表健康

        return Health.up().down().withDetail("msg","服务异常").build();
    }
}
