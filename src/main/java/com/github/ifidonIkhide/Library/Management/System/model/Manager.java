package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.embedded.Address;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.ManagerJobTitle;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NonNull
@Entity
@Table(name = "manager")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@AttributeOverride(name = "address", column = @Column(name = ""))
public class Manager extends Employee {

    @Enumerated(EnumType.STRING)
    @Column(name = "job_title", nullable = false)
    private ManagerJobTitle managerTitle;


    //Override  this
//    @Enumerated(EnumType.STRING)
//    @Column(name = "departments", nullable = false)
//    private Department department;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)                // I chose to use this annotation because this column is a complex one that needs to be only loaded when needed.
    @Column(name = "job_descriptions", nullable = false)
    private String managerJobDescriptions;

    @Override
    public String getJobDescriptions() {
        return managerJobDescriptions;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "manager_since", nullable = false)
    private LocalDate managerSince;

    @Column(name = "salary", nullable = false)
    private BigDecimal managerSalary;

    @Override
    public BigDecimal getSalary() {
        return managerSalary;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "houseNumber", column = @Column(name = "office_number")),
            @AttributeOverride(name = "street", column = @Column(name = "office_street")),
            @AttributeOverride(name = "city", column = @Column(name = "office_city")),
            @AttributeOverride(name = "state", column = @Column(name = "office_state")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "office_zip_code")),
            @AttributeOverride(name = "type", column = @Column(name = "office_address_type", nullable = false, columnDefinition = "VARCHAR(4) default 'WORK'"))
    })
    private Address officeAddress;


    // This is not working
    @Transient
    @Embedded
    private Address address;

    // A collection of employees (that are not supervisors) that directly reports to the Manager
    @OneToMany(mappedBy = "manager")
    private Set<Employee> employeesUnderManager = new HashSet<>();

    // A collection of supervisors (only) that directly reports to the Manager
    @OneToMany(mappedBy = "manager")
    private Set<Supervisor> supervisorsUnderManager = new HashSet<>();
}
