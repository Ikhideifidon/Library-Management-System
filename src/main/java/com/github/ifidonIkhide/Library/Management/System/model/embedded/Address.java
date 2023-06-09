package com.github.ifidonIkhide.Library.Management.System.model.embedded;

import com.github.ifidonIkhide.Library.Management.System.model.enumerate.AddressType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Size(min = 1, max = 99999, message = "House number must be a positive integer within 1 and 99999")
    @Column(name = "house_number", nullable = false, length = 5)
    private int houseNumber;

    @NotBlank(message = "Street cannot be null or blank")
    @Column(name = "street", nullable = false, length = 50)
    private String street;

    @NotBlank(message = "City cannot be null or blank")
    @Pattern(regexp = "^[A-za-z]{2,20}$")
    @Column(name = "city", nullable = false, length = 20)
    private String city;

    @Pattern(regexp = "^[A-Za-z]{2}$")
    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @NotBlank
    @Size(min = 5, max = 10)
    @Pattern(regexp = "^\\d{5}(-\\d{4})?$", message = "Zip code must be a valid US zip code")
    @Column(name = "zip_code", length = 10)
    private String zipCode;

    @NotNull(message = "Address type cannot be null or blank")
    @Enumerated(EnumType.STRING)
    @Column(name = "address_type", nullable = false)
    private AddressType type;

}


