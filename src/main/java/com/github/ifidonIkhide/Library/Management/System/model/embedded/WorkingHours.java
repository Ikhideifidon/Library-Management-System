package com.github.ifidonIkhide.Library.Management.System.model.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalTime;

@Embeddable
@NonNull
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHours {

    @Column(name = "day_of_week")
    private int dayOfWeek;

    @Temporal(TemporalType.TIME)
    @Column(name = "opening_time")
    private LocalTime openingTime;

    @Temporal(TemporalType.TIME)
    @Column(name = "closing_time")
    private LocalTime closingTime;
}
