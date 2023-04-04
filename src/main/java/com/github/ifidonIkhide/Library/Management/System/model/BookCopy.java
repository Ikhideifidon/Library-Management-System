package com.github.ifidonIkhide.Library.Management.System.model;


import com.github.ifidonIkhide.Library.Management.System.embedded.BookLibraryKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "book_copy")
@NonNull
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCopy {

    @EmbeddedId
    private BookLibraryKey id;

    @ManyToOne()
    @MapsId("bookId")
    @JoinColumn(name = "book_id",  referencedColumnName = "book_id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne()
    @MapsId("libraryId")
    @JoinColumn(name = "library_id", referencedColumnName = "library_id", insertable = false, updatable = false)
    private Library library;

    @Column(name = "number_of_copies")
    private int numberOfCopies;
}

