package com.clientrequest.clientrequest.repository;

import com.clientrequest.clientrequest.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends CrudRepository<Note, Integer> {
}
