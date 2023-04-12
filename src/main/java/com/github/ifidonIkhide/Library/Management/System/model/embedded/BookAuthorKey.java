package com.github.ifidonIkhide.Library.Management.System.model.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * This Embeddable class is a type of Many-To-Many relationship with no attribute
 */
@NotBlank
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookAuthorKey implements Serializable {


    @Column(name = "book_id")
    private long bookId;

    @Column(name = "author_id")
    private Long authorId;
}
