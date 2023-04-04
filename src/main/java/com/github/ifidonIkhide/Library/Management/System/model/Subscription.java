package com.github.ifidonIkhide.Library.Management.System.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subscriptions")
@NonNull
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private int id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_type")
    private SubscriptionName subscriptionName;

    @NonNull
    @Column(name = "price")
    private double price;

    @NonNull
    @Column(name = "duration")
    private int duration;                           // in months.

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Patron> user = new HashSet<>();
}

enum SubscriptionName {
    BASIC("Basic"),
    PREMIUM("Premium"),
    GOLD("Gold");

    private final String displayName;

    SubscriptionName(String displayName) {
        this.displayName = displayName;
    }


    // .................................................UX.......................................
    public String getDisplayName() {
        return displayName;
    }
}
