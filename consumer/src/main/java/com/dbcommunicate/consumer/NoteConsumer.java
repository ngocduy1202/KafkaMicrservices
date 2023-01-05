package com.dbcommunicate.consumer;

import com.dbcommunicate.service.NoteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NoteConsumer {
    @Autowired
    private NoteService noteService;

    @KafkaListener(topics = {"note-topic"}, groupId = "note-events-listener-group")
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        System.out.println("Consumer record: "+ consumerRecord.value());
        noteService.processEvent(consumerRecord);
    }

}
