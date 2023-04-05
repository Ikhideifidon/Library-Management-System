package com.github.ifidonIkhide.Library.Management.System.model;


import com.github.ifidonIkhide.Library.Management.System.model.enumerate.LoanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * This Entity is a new Association Entity between Book entity and Patron entity.
 */
@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private int loanId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    @Temporal(TemporalType.DATE)
    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "returned_date")
    private LocalDate returnedDate;

    //Many-To-Many Relational relationship between Loan and Library
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    private Library library;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private LoanStatus status;

    // Check if this book is loanable. Condition available book > 5
    // Check if this patron has previously loaned this book and, he is yet to return it.

    // .....................................LOAN SERVICE...................................
    private boolean isLoanable() {
        // Check if the number of available copies is within the borrowing window.
        if (this.book.getAvailableCopies() <= 5)
            return false;                   // Not loanable

        // Check if this patron has any active loans of this particular book
        for (Loan loan : this.patron.getLoans()) {
            if (loan.getBook().equals(this.book) && loan.getStatus() == LoanStatus.ACTIVE)
                return false;               // Not loanable
        }
        return true;                        // Loanable

    }
    // .....................................LOAN SERVICE...................................

    @PrePersist
    protected void setLoanDate() {
        this.loanDate = LocalDate.now();
    }

    @PreUpdate
    protected void setReturnedDate() {
        if (this.returnedDate != null)                           // The book was loaned
            this.returnedDate = LocalDate.now();                 // The book was returned on this day.
    }

    // Method to check if a book is overdue
    private boolean isOverdue() {
        if (returnedDate != null)                                // If returned then no overdue.
            return false;
        LocalDate currentDate = LocalDate.now();
        return this.dueDate.isBefore(currentDate);
    }

    @PostLoad
    private void updateLoanStatus() {
        if (returnedDate != null)
            status = LoanStatus.RETURNED;

        else if (isOverdue())
            status = LoanStatus.OVERDUE;

        else
            status = LoanStatus.ACTIVE;
    }

}
