package com.cagataycuruk.petcarebackend.service;

import com.cagataycuruk.petcarebackend.dto.PetDto;
import com.cagataycuruk.petcarebackend.dto.request.CreatePetRequest;
import com.cagataycuruk.petcarebackend.dto.request.UpdatePetRequest;
import com.cagataycuruk.petcarebackend.entity.Pet;
import com.cagataycuruk.petcarebackend.exception.PetNotFoundException;
import com.cagataycuruk.petcarebackend.mapper.PetMapper;
import com.cagataycuruk.petcarebackend.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class PetService {
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public PetService(PetRepository petRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    public PetDto getPetById(UUID id) {
        return petMapper.toPetDto(petRepository
                .findById(id)
                .orElseThrow(PetNotFoundException::new));
    }

    public PetDto createPet(CreatePetRequest createPetRequest) {
        Pet savedPet = this.petRepository.save(petMapper.createPetRequestToPetEntity(createPetRequest));

        return PetDto.builder()
                .name(savedPet.getName())
                .age(savedPet.getAge())
                .weight(savedPet.getWeight())
                .height(savedPet.getHeight())
                .gender(savedPet.getGender())
                .photoUrl(savedPet.getPhotoUrl())
                .build();
    }

    public PetDto updatePet(UUID petId, UpdatePetRequest updatePetRequest) {
        Pet updatedPet = petRepository.findById(petId)
                .map(pet -> {
                    Pet petEntity = petMapper.updatePetRequestToPetEntity(updatePetRequest);
                    return petRepository.save(petEntity);
                })
                .orElseThrow(PetNotFoundException::new);

        return petMapper.toPetDto(updatedPet);
    }

    public void deletePet(UUID petId) {
        petRepository.deleteById(petId);
    }
}
