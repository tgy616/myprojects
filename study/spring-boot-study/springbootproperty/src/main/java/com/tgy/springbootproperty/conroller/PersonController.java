package com.tgy.springbootproperty.conroller;

import com.tgy.springbootproperty.domin.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author DragonSwimDiving
 * @program springbootproperty
 * @Date 2019-06-06 17:58
 **/
@RestController
public class PersonController implements EnvironmentAware {

    @Autowired
    @Qualifier("person")
    private Person person;

    @GetMapping("/person/test")
    public Person test(){
        return person;
    }

    @Value("${person.id}")
    private Long id;
    @Value("${person.name:tgy}")
    private String name;
//    @Value("${person.age}")
    private Integer age;

    @GetMapping("/person/test/data")
    public Map<String,Object> data() {
        Map<String,Object> data=new LinkedHashMap<>();
        data.put("id",id);
        data.put("age",age);
        data.put("name",name);
        return data;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.age=environment.getProperty("person.age",Integer.class);
    }
}
