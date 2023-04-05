package com.github.ifidonIkhide.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NonNull
@Entity
@Table(name = "supervisors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supervisor extends Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "supervisor_id")
    private Integer id;

    @OneToMany(mappedBy = "supervisor")
    private Set<Employee> employeeSet = new HashSet<>();
}
