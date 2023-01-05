package com.clientrequest.clientrequest.controller;



import com.clientrequest.clientrequest.entity.Note;
import com.clientrequest.clientrequest.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;


    @PostMapping("/create")
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return noteService.saveNote(note);
    }

    @PostMapping("/update")
    public ResponseEntity<Note> updateNote(@RequestBody Note noteBody)
    {
        noteService.updateNote(noteBody);
        return ResponseEntity.status(200).body(noteBody);
    }

    @GetMapping(value = "/allNotes")
    public List<Note> getAllNote(){
        return noteService.getAllNotes();
    }

    @GetMapping(value = "/{noteId}")
    public ResponseEntity<Optional<Note>> getNoteById(@PathVariable Integer noteId){
        return noteService.getNoteById(noteId);
    }

    @PostMapping("/delete/{noteId}")
    public ResponseEntity<Object> deleteNoteById(@PathVariable Integer noteId){
        noteService.deleteNoteById(noteId);
        return ResponseEntity.status(200).body("Deleted note with id: "+noteId );
    }


}
