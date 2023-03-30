package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.embedded.BookAuthorId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// A Bridge Entity between Books and Authors Many-to_Many relationship
@Entity
@Table(name = "book_author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthor {

    @EmbeddedId
    private BookAuthorId id;

    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false)
    private Author author;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AuthorRole role;
}

enum AuthorRole {
    AUTHOR,
    EDITOR,
    TRANSLATOR,
    CONTRIBUTOR
}
