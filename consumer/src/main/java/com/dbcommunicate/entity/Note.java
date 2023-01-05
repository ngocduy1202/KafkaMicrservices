package com.dbcommunicate.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    private String content;

    private String progress;

}
