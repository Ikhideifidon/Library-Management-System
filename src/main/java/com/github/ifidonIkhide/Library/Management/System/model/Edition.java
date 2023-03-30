package com.github.ifidonIkhide.Library.Management.System.model;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "publication_date")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "total_copies")
    private int totalCopies;

    @Column(name = "available_copies")
    private int availableCopies;

    public boolean isAvailability() {
        return availableCopies > 0;
    }
}

enum CoverType {
    HARDCOVER,
    PAPERBACK,
    EBOOK,

}

enum Format {
    HARDCOVER,
    KINDLE,
    PDF,
    EPUB,
    AUDIOBOOK,
    LARGE_PRINT,
    BRAILLE,
    MAGAZINE,
    JOURNAL,
    REFERENCE_BOOK
}

enum Language {
    ENGLISH,
    FRENCH,
    GERMAN,
    SPANISH,
    OTHER
}

