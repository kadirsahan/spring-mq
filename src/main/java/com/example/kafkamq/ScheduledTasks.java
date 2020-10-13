package com.example.kafkamq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Value("${kafka.topic.input}")
    private String inputTopic;

    @Value("${mq.queue}")
    String queue;


    @Scheduled(fixedRate = 10)
    public void readMq() {
        //log.info("Value: {}", new Timestamp(System.currentTimeMillis()));
        String transaction = jmsTemplate.receiveAndConvert(queue).toString();
        //log.info("Value: {}", transaction);
        kafkaTemplate.send(inputTopic,transaction);
    }
}