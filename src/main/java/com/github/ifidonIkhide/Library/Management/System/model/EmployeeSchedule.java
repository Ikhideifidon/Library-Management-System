package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.embedded.WorkingHours;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NonNull
@Entity
@Table(name = "employee_schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @Embedded
    private WorkingHours workingHours;



}
