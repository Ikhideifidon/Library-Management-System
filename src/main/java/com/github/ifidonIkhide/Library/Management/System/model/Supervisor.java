package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Department;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.SalaryType;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.SupervisorJobTitle;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Title;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NonNull
@Entity
@Table(name = "supervisors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "title", column = @Column(name = "supervisor_title"))
public class Supervisor extends Employee {


    //Override  this
//    @Enumerated(EnumType.STRING)
//    @Column(name = "job_title")
//    private SupervisorJobTitle supervisorTitle;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)                // I chose to use this annotation because this column is a complex one that needs to be only loaded when needed.
    @Column(name = "job_descriptions", nullable = false)
    private String supervisorJobDescriptions;

    @Override
    public String getJobDescriptions() {
        return supervisorJobDescriptions;
    }

    @Column(name = "salary", nullable = false)
    private BigDecimal supervisorSalary;

    @Override
    public BigDecimal getSalary() {
        return supervisorSalary;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "supervisor_since")
    private LocalDate supervisorSince;

    @OneToMany(mappedBy = "supervisor")
    private Set<Employee> employeesUnderSupervision = new HashSet<>();
}
