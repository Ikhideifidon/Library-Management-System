package com.github.ifidonIkhide.Library.Management.System.embedded;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Embeddable
@Data
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class BookLibraryKey implements Serializable {

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "library_id")
    private int libraryId;
}
