package com.github.ifidonIkhide.Library.Management.System.model;


import com.github.ifidonIkhide.Library.Management.System.model.embedded.PatronLibraryKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "library_visits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryVisit {

    @EmbeddedId
    private PatronLibraryKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("patronId")
    @JoinColumn(name = "patron_id", referencedColumnName = "patron_id")
    private Patron patron;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("libraryId")
    @JoinColumn(name = "library_id", referencedColumnName = "library_id")
    private Library library;

    @NotNull
    @PastOrPresent
    @Column(name = "time_in", nullable = false)
    private LocalDateTime timeIn;

    @NotNull
    @PastOrPresent
    @Column(name = "time_out", nullable = false)
    private LocalDateTime timeOut;
}
