package com.github.ifidonIkhide.Library.Management.System.embedded;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @ElementCollection
    private List<Phone> phones = new ArrayList<>();

}

enum Gender {
    MALE,
    FEMALE
}

enum Contact {
    MOBILE,
    HOME,
    WORK,
}

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class Phone {
    private String number;
    private Contact type;
}
