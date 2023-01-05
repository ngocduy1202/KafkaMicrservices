package com.dbcommunicate.repository;

import com.dbcommunicate.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends CrudRepository<Note, Long> {
}
