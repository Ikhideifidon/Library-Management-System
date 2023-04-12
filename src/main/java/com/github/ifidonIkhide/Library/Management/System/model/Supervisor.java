package com.github.ifidonIkhide.Library.Management.System.model;

import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Criteria;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.RatingScale;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.RatingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    private Manager manager;


    // Evaluate the Employee
    public Rating createRating(Employee employee, RatingScale ratingScale, String comment, String goal, String developmentPlan, RatingStatus status) {
        Rating rating = new Rating();
        for (Criteria criteria1 : Criteria.values()) {
            rating.setCriteria(criteria1);
            rating.setRatingScale(ratingScale);
        }
        rating.setDateOfRating(LocalDateTime.now());
        rating.setComment(comment);
        rating.setGoal(goal);
        rating.setDevelopmentPlan(developmentPlan);
        rating.setStatus(status);
        rating.setEmployee(employee);
        rating.setEvaluator(this);

        employee.addRating(rating);

        return rating;
    }
}
