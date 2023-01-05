package com.dbcommunicate.service;


import com.dbcommunicate.entity.Note;

import com.dbcommunicate.repository.NoteRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Transactional
@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;
    @Autowired
    private ObjectMapper objectMapper;

    public ResponseEntity<Note> saveNote(Note note){

        return ResponseEntity.ok(noteRepo.save(note));
    }

    public ResponseEntity<Note> updateNote(Note note){

        return ResponseEntity.ok(noteRepo.save(note));
    }


    public void processEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        Note note = objectMapper.readValue(consumerRecord.value(), Note.class);
        saveNote(note);
        System.out.println("Persis data to DB completed!");
    }

}
