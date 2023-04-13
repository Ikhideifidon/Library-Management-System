package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Criteria;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Measure;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.RatingScale;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.RatingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

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

    public int getOverallRating(Map<Criteria, Measure> criteriaScore) {
        // Assume the Supervisor chose this scale: RatingScale ratingScale = RatingScale.POOR_TO_OUTSTANDING;
        criteriaScore.put(Criteria.JOB_KNOWLEDGE, Measure.SATISFACTORY);
        criteriaScore.put(Criteria.COMMUNICATION_SKILLS, Measure.BELOW_AVERAGE);
        criteriaScore.put(Criteria.INITIATIVE, Measure.SATISFACTORY);
        criteriaScore.put(Criteria.ADAPTABILITY, Measure.ABOVE_AVERAGE);
        criteriaScore.put(Criteria.TEAMWORK, Measure.OUTSTANDING);
        criteriaScore.put(Criteria.CUSTOMER_SERVICE, Measure.SATISFACTORY);
        criteriaScore.put(Criteria.TIME_MANAGEMENT, Measure.SATISFACTORY);
        criteriaScore.put(Criteria.LEADERSHIP, Measure.ABOVE_AVERAGE);
        criteriaScore.put(Criteria.PROBLEM_SOLVING, Measure.SATISFACTORY);
        criteriaScore.put(Criteria.DEPENDABILITY, Measure.OUTSTANDING);

        int count = Criteria.values().length;
        int sum = 0;
        for (Measure measure : criteriaScore.values()) {
            if (measure != null)
                sum += measure.getValue();
        }
        overallRating = count > 0 ? Math.round(sum / (float) count) : 0;
        return overallRating;
    }

}
