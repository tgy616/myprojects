package com.tgy.springbootmsgs.consumer;

import com.tgy.springbootmsgs.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者监听
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see
 * @since 2017.08.09
 */
@Component
public class ConsumerListener {


    @KafkaListener(topics = "tgy")
    public void consumer(String message) {

        System.out.println(message);

    }


    @KafkaListener(topics = "tgy-users")
    public void consumer(User user) {

        System.err.println(user);

    }

}
