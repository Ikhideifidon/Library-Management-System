package com.github.ifidonIkhide.Library.Management.System.model;


import com.github.ifidonIkhide.Library.Management.System.model.embedded.Address;
import com.github.ifidonIkhide.Library.Management.System.model.embedded.Person;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Department;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.SalaryType;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Title;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NonNull
@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @Embedded
    private Person person;

    @Embedded
    private Address address;

    // In this Embedded, for the Contact enum, only the EnumType.WORK will be made available to
    // the general patrons. Every other Contact EnumType will be used for the sole purpose of
    // administration.

    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_title")
    private Title title;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)                // I chose to use this annotation because this column is a complex one that needs to be only loaded when needed.
    @Column(name = "job_descriptions")
    private String jobDescriptions;

    @Enumerated(EnumType.STRING)
    @Column(name = "departments")
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(name = "salary_type", nullable = false)
    private SalaryType salaryType;

    @Column(name = "salary")
    private BigDecimal salary;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeSchedule> schedule = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Manager manager;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Supervisor supervisor;
}
