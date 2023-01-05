package com.kafkaservice.kafka.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafkaservice.kafka.producer.KafkaProducerConfig;
import com.kafkaservice.kafka.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kafkaservice.kafka.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private KafkaProducerConfig kafkaProducer;


//    @PostMapping("/create")
//    public ResponseEntity<Note> addNote(@RequestBody Note note){
//        return noteService.saveNote(note);
//    }

//    @PostMapping("/update")
//    public ResponseEntity<Note> updateNote(@RequestBody Note noteBody){
//        return noteService.updateNote(noteBody);
//    }

    @PostMapping("/kafka/create")
    public ResponseEntity<Note> createNote(@RequestBody Note note) throws JsonProcessingException {
        kafkaProducer.sendMessage(note);
        return ResponseEntity.ok(note);
    }

    @PostMapping("/kafka/update")
    public ResponseEntity<Note> updateNote(@RequestBody Note note) throws JsonProcessingException {
        kafkaProducer.sendMessage(note);
        return ResponseEntity.ok(note);
    }
}
