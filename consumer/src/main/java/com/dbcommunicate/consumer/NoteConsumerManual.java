package com.dbcommunicate.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

//@Component
//public class NoteConsumerManual implements AcknowledgingConsumerAwareMessageListener<Integer, String> {
//    @KafkaListener(topics = {"note-topic"}, groupId = "note-events-listener-group")
//    @Override
//    public void onMessage(ConsumerRecord<Integer, String> consumerRecord, Acknowledgment acknowledgment, Consumer<?, ?> consumer) {
//        System.out.println("Consumer record: "+ consumerRecord);
//        acknowledgment.acknowledge();
//    }
//
//
//}
