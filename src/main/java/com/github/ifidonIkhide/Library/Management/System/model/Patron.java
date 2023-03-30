package com.github.ifidonIkhide.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "patrons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patron_id")
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "library_card_number")
    private String libraryCardNumber;

    @Column(name = "account_balance")
    private float accountBalance;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private PatronStatus status;

    @Column(name = "is_staff")
    private boolean isStaff;

    @OneToMany(mappedBy = "patron")  // "patron" refers to the patron field in the "Loan" entity
    Set<Loan> loans;

}


enum PatronStatus {
    ACTIVE,
    INACTIVE,
    SUSPENDED,
}
