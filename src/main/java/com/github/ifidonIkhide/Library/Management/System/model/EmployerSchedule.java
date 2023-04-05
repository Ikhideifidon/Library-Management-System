package com.github.ifidonIkhide.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.DayOfWeek;
import java.time.LocalTime;

@NonNull
@Entity
@Table(name = "employee_schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "supervisor_id", referencedColumnName = "supervisor_id")
    private Supervisor supervisor;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @Temporal(TemporalType.TIME)
    @Column(name = "start_time")
    private LocalTime startTime;

    @Temporal(TemporalType.TIME)
    @Column(name = "end_time")
    private LocalTime endTime;



}
