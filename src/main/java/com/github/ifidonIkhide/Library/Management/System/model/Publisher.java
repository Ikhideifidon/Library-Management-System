package com.github.ifidonIkhide.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    // One-To-Many relationship between a publisher and its book(s)
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)       // "publisher" refers to the name of the field in the Book entity that maps the relationship back to the Publisher entity.
    private Set<Book> books = new HashSet<>();

}
