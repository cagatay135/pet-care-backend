package com.cagataycuruk.petcarebackend.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PetDto {
    private UUID id;

    private String name;

    private Integer age;

    private float weight;

    private float height;

    private String photoUrl;

    private LocalDate birthday;
}
