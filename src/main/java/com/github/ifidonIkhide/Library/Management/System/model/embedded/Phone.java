package com.github.ifidonIkhide.Library.Management.System.model.embedded;

import com.github.ifidonIkhide.Library.Management.System.model.enumerate.Contact;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class Phone {

    @NotBlank(message = "Phone number cannot be null")
    @Pattern(regexp = "(^$|[0-9]{10})")
    @Column(name = "phone_number")
    private String number;

    @NotBlank(message = "Contact Type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "phone_number_type")
    private Contact type;

    // Define a transient field to store the formatted phone number
    @Transient
    private String formattedNumber;

    // Define a custom getter for the formattedNumber field
    public String getFormattedNumber() {
        // Format the phone number as an (XXX)-XXX-XXXX
        formattedNumber = String.format("(%s)-%s-%s",
                    number.substring(0, 3),
                    number.substring(3, 6),
                    number.substring(6));
        return formattedNumber;
    }

}
