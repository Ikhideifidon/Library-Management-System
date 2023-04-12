package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.embedded.Address;
import com.github.ifidonIkhide.Library.Management.System.model.embedded.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    private Long id;

    @Embedded
    private Person person;

    @Embedded
    private Address address;

    // Many-To-Many relationship between Author and Book
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)   // "author" refers to the author field in the "BookAuthor" bridge entity
    @MapsId("author")
    @Size(min = 1, message = "Author must have at least one role")
    private List<AuthorRole> authorRoles = new ArrayList<>();
}
