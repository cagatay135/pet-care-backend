package com.cagataycuruk.petcarebackend.dto;

import com.cagataycuruk.petcarebackend.enums.FileType;
import lombok.*;

import java.util.UUID;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PetFileDto{
    private UUID petId;
    private FileType fileType;
    private String fileUrl;
}

