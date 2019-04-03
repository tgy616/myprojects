package com.tgy.springbootmsgs;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * 生产者 测试
 *
 * @author tanggy
 * @date 2018/6/11
 */
public class ProducerMain {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9091,localhost:9092,localhost:9093");
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);
        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("tgy", 0,
                "message", "hello erverbody!");
        Future<RecordMetadata> future = kafkaProducer.send(producerRecord);
        RecordMetadata recordMetadata = future.get();
        System.out.println(recordMetadata);

    }
}
