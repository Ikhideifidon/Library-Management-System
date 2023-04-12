package com.github.ifidonIkhide.Library.Management.System.model.embedded;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Embeddable
@NonNull
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHours {

    @NotNull(message = "Day of the week cannot be null")
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    @NotNull(message = "Opening time cannot be null")
    @Temporal(TemporalType.TIME)
    @Column(name = "opening_time")
    private LocalTime openingTime;

    @NotNull(message = "Closing time cannot be null")
    @Temporal(TemporalType.TIME)
    @Column(name = "closing_time")
    private LocalTime closingTime;
}
