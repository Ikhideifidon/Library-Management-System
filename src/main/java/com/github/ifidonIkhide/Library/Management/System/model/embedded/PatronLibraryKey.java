package com.github.ifidonIkhide.Library.Management.System.model.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NotBlank
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatronLibraryKey implements Serializable {

    @Column(name = "patron_id")
    private long patronId;

    @Column(name = "library_id")
    private Long libraryId;
}
