package com.tgy.activiti;

import com.tgy.activiti.dao.CompRepository;
import com.tgy.activiti.dao.PersonRepository;
import com.tgy.activiti.entity.Comp;
import com.tgy.activiti.entity.Person;
import com.tgy.activiti.service.ActivitiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.fengye.example")
@EnableJpaRepositories("com.fengye.example.dao")
@EntityScan("com.fengye.example.model")
public class ActivitiApplication {

    @Autowired
    private CompRepository compRepository;
    @Autowired
    private PersonRepository personRepository;


    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class, args);
    }

    //初始化模拟数据
    @Bean
    public CommandLineRunner init(final ActivitiService myService) {
        return new CommandLineRunner() {
            public void run(String... strings) throws Exception {
                if (personRepository.findAll().size() == 0) {
                    personRepository.save(new Person("wtr"));
                    personRepository.save(new Person("wyf"));
                    personRepository.save(new Person("admin"));
                }
                if (compRepository.findAll().size() == 0) {
                    Comp group = new Comp("great company");
                    compRepository.save(group);
                    Person admin = personRepository.findByPersonName("admin");
                    Person wtr = personRepository.findByPersonName("wtr");
                    admin.setComp(group); wtr.setComp(group);
                    personRepository.save(admin); personRepository.save(wtr);
                }
            }
        };
    }
}
