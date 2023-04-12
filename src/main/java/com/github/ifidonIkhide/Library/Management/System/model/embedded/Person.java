package com.github.ifidonIkhide.Library.Management.System.model.embedded;

import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Contact;
import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 2, max = 50, message = "First Name cannot be null")
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @NotBlank
    @Size(min = 2, max = 50, message = "Last Name cannot be null")
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Past
    @Column(name = "birth_date")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Gender cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @ElementCollection
    private List<Phone> phones = new ArrayList<>();

}
