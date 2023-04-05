package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.enumerate.CoverType;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Format;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "editions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edition_id")
    private Long editionId;

    @Column(name = "edition_number")
    private String editionNumber;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    @Column(name = "isbn")
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "cover_type")
    private CoverType coverType;

    @Column(name = "page_count")
    private int pageCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "format")
    private Format format;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Language language;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "notes")
    private String notes;

    // Many-To-One Relationship between a book edition and the book
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    @Column(name = "total_copies")
    private int totalCopies;

    @Column(name = "available_copies")
    private int availableCopies;

    public boolean isAvailability() {
        return availableCopies > 0;
    }
}

