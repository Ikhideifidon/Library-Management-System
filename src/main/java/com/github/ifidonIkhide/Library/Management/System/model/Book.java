package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@NonNull
@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "call_number")
    private String callNumber;

    @Column(name = "subject_headings")
    private String subjectHeadings;

    @Column(name = "awards")
    private String awards;

    @Column(name = "available_copies")
    private int availableCopies;

    @Enumerated(EnumType.STRING)
    @Column(name = "genres")
    private Genre genre;

    // One-To-Many relationship between a book and its edition(s)
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Edition> editions = new HashSet<>();

    // Many-To-One relationship between Books and a publisher
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    // Many-To-Many relationship between a book and its authors
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AuthorRole> authorRoles = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BookCopy> bookCopies = new HashSet<>();

    //...........................UX...............................
    // How many edition does this book have?
    @Transient
    private int numberOfEditions;

    @PostLoad
    public void setNumberOfEditions() {
        numberOfEditions = editions.size();
    }

}