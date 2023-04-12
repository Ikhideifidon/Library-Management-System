package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.embedded.Address;
import com.github.ifidonIkhide.Library.Management.System.model.embedded.WorkingHours;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
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
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100, message = "Library must have a name within the range of 2 to 100 characters")
    @Column(name = "name", columnDefinition = "VARCHAR(100)")
    private String name;

    @Embedded
    @AttributeOverride(name = "houseNumber", column = @Column(name = "building_number"))
    private Address address;

    @NotBlank(message = "Phone number cannot be null")
    @Pattern(regexp = "(^$|[0-9]{10})")
    @Column(name = "office_number", nullable = false, columnDefinition = "VARCHAR(10)")
    private String officeNumber;

    // working hours
    @ElementCollection
    @CollectionTable(name = "library_working_hours", joinColumns = @JoinColumn(name = "library_id"))
    @NotEmpty(message = "Working hours cannot be empty")
    private Set<WorkingHours> workingHours = new HashSet<>();

    //.........................................SERVICE...........................................
    public void setWorkingHours() {
        // set working hours for weekdays
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY)
                workingHours.add(new WorkingHours(dayOfWeek, LocalTime.of(8, 0), LocalTime.of(22, 0)));
        }
        // set working hours for weekends
        workingHours.add(new WorkingHours(DayOfWeek.SATURDAY, LocalTime.of(10, 0), LocalTime.of(20, 0)));
        workingHours.add(new WorkingHours(DayOfWeek.SUNDAY, LocalTime.of(10, 0), LocalTime.of(20, 0)));
    }

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private Set<LibraryVisit> patronsUsingLibrary = new HashSet<>();


    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Loan> loans = new HashSet<>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();
}
