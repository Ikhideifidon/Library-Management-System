package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.embedded.Address;
import com.github.ifidonIkhide.Library.Management.System.embedded.WorkingHours;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "libraries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;

    @NonNull
    // Irrespective of the format the user enters, I want it to be stored in my database as +1(908)-445-5272
    @Column(name = "phone_number", nullable = false, length = 12)
    private String phoneNumber;

    // working hours
    @ElementCollection
    @CollectionTable(name = "library_working_hours",
            joinColumns = @JoinColumn(name = "library_id"))
    private Set<WorkingHours> workingHours = new HashSet<>();

    public void setWorkingHours() {
        // set working hours for weekdays
        for (int day = Calendar.MONDAY; day <= Calendar.FRIDAY; day++)
            workingHours.add(new WorkingHours(day, LocalTime.of(8, 0), LocalTime.of(22, 0)));

        // set working hours for weekends
        workingHours.add(new WorkingHours(Calendar.SATURDAY, LocalTime.of(10, 0), LocalTime.of(20, 0)));
        workingHours.add(new WorkingHours(Calendar.SUNDAY, LocalTime.of(10, 0), LocalTime.of(20, 0)));
    }

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BookCopy> bookCopies = new HashSet<>();
}
