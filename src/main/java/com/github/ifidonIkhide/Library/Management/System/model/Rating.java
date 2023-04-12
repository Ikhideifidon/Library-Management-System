package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Criteria;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.RatingScale;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.RatingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long id;

    @Column(name = "date_of_rating")
    private LocalDateTime dateOfRating;

    @Enumerated(EnumType.STRING)
    @Column(name = "criteria")
    private Criteria criteria;

    @Enumerated(EnumType.STRING)
    @Column(name = "ratingScale")
    private RatingScale ratingScale;

    @Transient
    private int overallRating;

    @Column(name = "comments")
    private String comment;

    @Column(name = "goals")
    private String goal;

    @Column(name = "development_plan")
    private String developmentPlan;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RatingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluator_id", referencedColumnName = "employee_id")
    private Employee evaluator;

    public void setEmployee(Employee employee) {
        this.employee = employee;
        employee.addRating(this);
    }

    public void setEvaluator(Employee evaluator) {                   // Evaluators evaluate employee.
        if (evaluator instanceof Supervisor && !evaluator.equals(employee))
            this.evaluator = evaluator;
        else
            throw new IllegalArgumentException("Evaluator must be a Supervisor and not the Employee being rated or the Manager.");
    }

}
