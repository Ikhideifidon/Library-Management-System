package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.embedded.Address;
import com.github.ifidonIkhide.Library.Management.System.embedded.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Embedded
    private Person person;

    @Embedded
    private Address address;

    // Many-To-Many relationship between Author and Book
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)   // "author" refers to the author field in the "BookAuthor" bridge entity
    private List<AuthorRole> authorRoles = new ArrayList<>();
}
