package com.clientrequest.clientrequest.service;

import com.clientrequest.clientrequest.entity.Note;
import com.clientrequest.clientrequest.repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;

    public List<Note> getAllNotes(){
       List<Note> listNote =
        (List<Note>) noteRepo.findAll();
       return listNote;
    }

    public ResponseEntity<Optional<Note>> getNoteById(Integer id){
        return ResponseEntity.ok(noteRepo.findById(id));
    }


    public ResponseEntity<Note> saveNote(Note note){
        return ResponseEntity.ok(noteRepo.save(note));
    }

    public ResponseEntity<Note> updateNote(Note note){
        return ResponseEntity.ok(noteRepo.save(note));
    }

    public void deleteNoteById(Integer noteId){        noteRepo.deleteById(noteId);

    }


}
