package com.github.ifidonIkhide.Library.Management.System.model;


import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Department;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Salary;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NonNull
@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee extends Patron {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    // In this Embedded, for the Contact enum, only the EnumType.WORK will be made available to
    // the general patrons. Every other Contact EnumType will be used for the sole purpose of
    // administration.

    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "job_title")
    private String jobTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "departments")
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(name = "salary", nullable = false)
    private Salary salary;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "supervisor_id", referencedColumnName = "supervisor_id")
    private Supervisor supervisor;

    @OneToMany(mappedBy = "employee")
    private Set<EmployerSchedule> schedule = new HashSet<>();
}
