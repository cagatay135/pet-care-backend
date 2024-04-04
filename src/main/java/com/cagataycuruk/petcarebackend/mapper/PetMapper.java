package com.cagataycuruk.petcarebackend.mapper;

import com.cagataycuruk.petcarebackend.dto.PetDto;
import com.cagataycuruk.petcarebackend.dto.request.CreatePetRequest;
import com.cagataycuruk.petcarebackend.dto.request.UpdatePetRequest;
import com.cagataycuruk.petcarebackend.entity.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

    PetDto toPetDto(Pet pet);

    Pet toPetEntity(PetDto petDto);

    Pet createPetRequestToPetEntity(CreatePetRequest createPetRequest);
    Pet updatePetRequestToPetEntity(UpdatePetRequest updatePetRequest);

}