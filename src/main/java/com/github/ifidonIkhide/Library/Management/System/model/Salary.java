package com.github.ifidonIkhide.Library.Management.System.model;


import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Frequency;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.SalaryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "salaries")
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Long id;

    @NonNull
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "salary_type", nullable = false)
    private SalaryType salaryType;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "frequency", nullable = false)
    private Frequency frequency;

    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date",nullable = false)
    private LocalDate startDate;

    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @NonNull
    @Column(name = "tax_deduction", nullable = false)
    private BigDecimal taxDeduction;

    // ManyToOne Relationship between Employee and Salary
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;
}
