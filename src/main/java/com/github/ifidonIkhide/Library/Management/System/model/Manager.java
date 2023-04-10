package com.github.ifidonIkhide.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "managers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "employee_id")
public class Manager extends Employee {

    @Temporal(TemporalType.DATE)
    @Column(name = "manager_since")
    private LocalDate managerSince;

    // A collection of employees (that are not supervisors) that directly reports to the Manager
    @OneToMany(mappedBy = "manager")
    private Set<Employee> employeesUnderManager = new HashSet<>();

    // A collection of supervisors (only) that directly reports to the Manager
    @OneToMany(mappedBy = "manager")
    private Set<Supervisor> supervisorsUnderManager = new HashSet<>();
}
