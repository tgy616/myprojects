package com.tgy.springbootstart.autoconfigure;

import com.tgy.springbootstart.controller.PersonRestController;
import com.tgy.springbootstart.domain.Person;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link Person}自动装配
 * @author DragonSwimDiving
 * @program springbootstart
 * @Date 2019-06-20 17:09
 **/
//@Configuration
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "person", name = "enabled", havingValue = "true")
//@AutoConfigureAfter(EmbeddedServletContainerAutoConfiguration.class)
public class PersonAutoConfigeruration {

    @ConfigurationProperties(prefix = "person")
    @Bean
    public Person person() {
        return new Person();
    }
//
//    @Bean
//    public PersonRestController personRestController(Person person) {
//        return new PersonRestController(person);
//    }

}
