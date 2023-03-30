package com.github.ifidonIkhide.Library.Management.System.model;


import com.github.ifidonIkhide.Library.Management.System.embedded.LoanId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @EmbeddedId
    private LoanId id;

    @ManyToOne
    @MapsId("patronId")   // patronId from the Bridge table
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @ManyToOne
    @MapsId("bookId")       // bookId from the Bridge table
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "loan_date")
    private Date loanDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "return_date")
    private Date returnDate;

//    @ManyToOne
//    @JoinColumn(name = "branch_id")
//    private Branch branch;



}
