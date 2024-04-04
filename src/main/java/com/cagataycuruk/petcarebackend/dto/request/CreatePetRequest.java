package com.cagataycuruk.petcarebackend.dto.request;


import com.cagataycuruk.petcarebackend.enums.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreatePetRequest {
    @NotEmpty(message="Pet name cannot be null")
    private String name;

    @Min(0)
    private Integer age;

    @Min(0)
    private float weight;

    @Min(0)
    private float height;

    private LocalDate birthday;

    private Gender gender;
}
