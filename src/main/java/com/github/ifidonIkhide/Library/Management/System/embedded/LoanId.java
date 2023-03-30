package com.github.ifidonIkhide.Library.Management.System.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LoanId implements Serializable {
    @Column(name = "patron_id")
    private long patronId;

    @Column(name = "book_id")
    private long bookId;
}
