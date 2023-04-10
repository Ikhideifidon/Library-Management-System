package com.github.ifidonIkhide.Library.Management.System.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "supervisors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "employee_id")
public class Supervisor extends Employee {

    @Temporal(TemporalType.DATE)
    @Column(name = "supervisor_since")
    private LocalDate supervisorSince;

    @OneToMany(mappedBy = "supervisor")
    private Set<Employee> employeesUnderSupervision = new HashSet<>();
}
