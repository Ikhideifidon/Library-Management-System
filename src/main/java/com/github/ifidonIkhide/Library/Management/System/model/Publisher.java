package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.embedded.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_id")
    private int id;

    @Column(name = "company")
    private String companyName;

    @Embedded
    private Address address;

    @Column(name = "email")
    private String email;

    // One-To-Many relationship between a publisher and its book(s)
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)       // "publisher" refers to the name of the field in the Book entity that maps the relationship back to the Publisher entity.
    private Set<Book> books = new HashSet<>();

}
