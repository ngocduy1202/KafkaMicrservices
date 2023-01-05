package com.kafkaservice.kafka.service;

import com.kafkaservice.kafka.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.kafkaservice.kafka.repository.NoteRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;

    public ResponseEntity<List<Note>> getAllNotes(){
        return (ResponseEntity<List<Note>>) noteRepo.findAll();
    }

    public ResponseEntity<Optional<Note>> getNoteById(Long id){
        return ResponseEntity.ok(noteRepo.findById(id));
    }

    public ResponseEntity<Note> saveNote(Note note){
        return ResponseEntity.ok(noteRepo.save(note));
    }

    public ResponseEntity<Note> updateNote(Note note){
        return ResponseEntity.ok(noteRepo.save(note));
    }



}
