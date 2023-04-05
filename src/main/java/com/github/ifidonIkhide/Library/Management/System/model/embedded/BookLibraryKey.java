package com.github.ifidonIkhide.Library.Management.System.model.embedded;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookLibraryKey implements Serializable {

    @Column(name = "book_id")
    private long bookId;

    @Column(name = "library_id")
    private int libraryId;
}
