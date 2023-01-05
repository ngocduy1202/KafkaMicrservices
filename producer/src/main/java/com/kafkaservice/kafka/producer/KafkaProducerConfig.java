package com.kafkaservice.kafka.producer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaservice.kafka.entity.Note;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
public class KafkaProducerConfig {
    @Autowired
    KafkaTemplate<Integer,String> kafkaTemplate;
    String topic = "note-topic";
    @Autowired
    ObjectMapper objectMapper;


    public void sendMessage(Note note) throws JsonProcessingException {

        Integer key = (int) note.getNoteId();
        String value = objectMapper.writeValueAsString(note);

        ListenableFuture<SendResult<Integer,String>> listenableFuture =  kafkaTemplate.sendDefault(key,value);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key, value, result);
            }
        });
    }

    private void handleFailure(Integer key, String value, Throwable ex) {
        try {
            throw ex;
        } catch (Throwable throwable) {
            System.out.println("Message sent unsuccessful with: "+value );
        }
    }

    private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
        System.out.println("Message sent Successfully with: - "+value);
    }
}
