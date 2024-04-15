package com.cagataycuruk.petcarebackend.mapper;

import com.cagataycuruk.petcarebackend.dto.PetFileDto;
import com.cagataycuruk.petcarebackend.entity.PetFile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetFileMapper {
    PetFileDto toPetFileDto(PetFile petFile);
}