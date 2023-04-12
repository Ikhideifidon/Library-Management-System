package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.embedded.Address;
import com.github.ifidonIkhide.Library.Management.System.model.embedded.Person;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Department;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.EmploymentType;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Title;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @NonNull
    @Embedded
    private Person person;

    @NonNull
    @Embedded
    private Address address;

    // In this Embedded, for the Contact enum, only the EnumType.WORK will be made available to
    // the general patrons. Every other Contact EnumType will be used for the sole purpose of
    // administration.

    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "job_title")
    private Title title;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "employment_type")
    private EmploymentType employmentType;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "departments")
    private Department department;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Benefit> benefits = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Salary> salaries = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<EmployeeSchedule> schedules = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Manager manager;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Supervisor supervisor;

    @OneToMany(mappedBy = "employee")
    private List<JobDescription> jobDescriptions = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emergency_id")
    private EmergencyContact emergencyContact;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Rating> ratings = new ArrayList<>();

    public void addRating(Rating rating) {
        ratings.add(rating);
        rating.setEmployee(this);                   // Set the owner of this rating.
    }

    public void addAllRatings(List<Rating> allRatings) {
        allRatings.forEach(this::addRating);
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
        rating.setEmployee(null);                   // Set the owner of this rating.
    }

    public void removeAllRatings(List<Rating> allRatings) {
        allRatings.forEach(this::removeRating);
    }

    public List<Rating> getRatings() {
        return Collections.unmodifiableList(ratings);
    }

    @Version
    private Long version;
}
