package com.fasthink.kafka.basic;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BasicConsumer {

    @KafkaListener(topics = "${kafka.topic.basictopic}", containerFactory = "basicKafkaListenerContainerFactory")
    public void receive(Basic basic) {

        System.out.println(basic.toString());
    }
}
