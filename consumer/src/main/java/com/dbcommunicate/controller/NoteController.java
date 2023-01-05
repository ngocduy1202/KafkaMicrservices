package com.dbcommunicate.controller;


import com.dbcommunicate.entity.Note;
import com.dbcommunicate.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;


    @PostMapping("/create")
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return noteService.saveNote(note);
    }

//    @PostMapping("/update")
//    public ResponseEntity<Note> updateNote(@RequestBody Note noteBody){
//        return noteService.updateNote(noteBody);
//    }


}
