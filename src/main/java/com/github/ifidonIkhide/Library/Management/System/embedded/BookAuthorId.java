package com.github.ifidonIkhide.Library.Management.System.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BookAuthorId implements Serializable {

    @Column(name = "book_id")
    private long bookId;

    @Column(name = "author_id")
    private int authorId;
}
