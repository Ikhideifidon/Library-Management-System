package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.embedded.Address;
import com.github.ifidonIkhide.Library.Management.System.model.embedded.Person;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.PatronStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patrons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patron_id")
    private Integer id;

    @Embedded
    private Person person;

    @Column(name = "user_image_url")
    private String userImageUrl = "https://example.com/default-image.jpg";

    @Embedded
    private Address address;

    @Column(name = "library_card_number")
    private String libraryCardNumber;

    @Column(name = "account_balance")
    private float accountBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private PatronStatus status;

    @Column(name = "is_staff")
    private boolean isStaff;

    @OneToMany(mappedBy = "patron")  // "patron" refers to the patron field in the "Loan" entity
    Set<Loan> loans = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergency_id")
    private EmergencyContact emergencyContact;

}