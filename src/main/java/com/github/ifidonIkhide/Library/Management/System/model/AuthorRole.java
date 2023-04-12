package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.embedded.BookAuthorKey;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Role;
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
public class AuthorRole {

    @EmbeddedId
    private BookAuthorKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId("authorId")
    @JoinColumn(name = "author_id", referencedColumnName = "author_id", insertable = false, updatable = false)
    private Author author;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
