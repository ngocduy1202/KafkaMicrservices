package com.kafkaservice.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("local")
public class KafkaTopicConfig {

    @Bean
    public NewTopic NoteTopic(){
//        return TopicBuilder.name("note-topic")
//                .partitions(3)
//                .replicas(1)
//                .build();
        return new NewTopic("note-topic", 4, (short) 1);
    }
}
