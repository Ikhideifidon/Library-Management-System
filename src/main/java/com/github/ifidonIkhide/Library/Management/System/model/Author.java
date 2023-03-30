package com.github.ifidonIkhide.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate birthDate;

    // One-To-Many relationship between authors and BookAuthor
    @OneToMany(mappedBy = "author")   // "author" refers to the author field in the "BookAuthor" bridge entity
    private Set<BookAuthor> bookAuthorSet = new HashSet<>();
}
