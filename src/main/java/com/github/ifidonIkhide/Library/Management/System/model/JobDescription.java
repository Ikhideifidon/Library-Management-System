package com.github.ifidonIkhide.Library.Management.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "job_descriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "description_id")
    private Long id;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)                // I chose to use this annotation because this column is a complex one that needs to be only loaded when needed.
    @Column(name = "descriptions", nullable = false)
    private String descriptions;


    @Column(name = "effective_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate effectiveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @Version
    private Long version;
}
