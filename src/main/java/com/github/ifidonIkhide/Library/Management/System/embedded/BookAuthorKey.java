package com.github.ifidonIkhide.Library.Management.System.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * This Embeddable class is a type of Many-To-Many relationship with no attribute
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthorKey implements Serializable {


    @Column(name = "book_id")
    private long bookId;

    @Column(name = "author_id")
    private int authorId;
}
