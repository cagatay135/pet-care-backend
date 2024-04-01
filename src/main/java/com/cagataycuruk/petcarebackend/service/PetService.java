package com.cagataycuruk.petcarebackend.service;

import com.cagataycuruk.petcarebackend.dto.PetDto;
import com.cagataycuruk.petcarebackend.entity.Pet;
import com.cagataycuruk.petcarebackend.exception.PetNotFoundException;
import com.cagataycuruk.petcarebackend.mapper.PetMapper;
import com.cagataycuruk.petcarebackend.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
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

    public PetDto createPet(PetDto petDto) {
        Pet petEntity = this.petRepository.save(petMapper.toPetEntity(petDto));
        petRepository.save(petEntity);
        return petDto;
    }
}
