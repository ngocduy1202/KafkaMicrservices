package com.kafkaservice.kafka.repository;

import com.kafkaservice.kafka.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepo extends CrudRepository<Note, Long> {
}
