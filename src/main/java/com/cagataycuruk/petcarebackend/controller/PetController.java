package com.cagataycuruk.petcarebackend.controller;

import com.cagataycuruk.petcarebackend.dto.PetDto;
import com.cagataycuruk.petcarebackend.dto.request.CreatePetRequest;
import com.cagataycuruk.petcarebackend.dto.request.UpdatePetRequest;
import com.cagataycuruk.petcarebackend.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDto> findById(@PathVariable UUID id) {
        PetDto petDto = petService.getPetById(id);
        return ResponseEntity.ok(petDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDto> updatePet(@PathVariable UUID id, @Valid @RequestBody UpdatePetRequest updatePetRequest) {
        PetDto petDto = petService.updatePet(id, updatePetRequest);
        return ResponseEntity.ok(petDto);
    }

    @PostMapping("")
    public ResponseEntity<PetDto> createPet(@Valid @RequestBody CreatePetRequest createPetRequest) {
        PetDto petDto = petService.createPet(createPetRequest);
        return ResponseEntity.ok(petDto);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable  UUID id){
        petService.deletePet(id);
    }
}
