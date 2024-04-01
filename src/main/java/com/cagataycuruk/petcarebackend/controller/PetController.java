package com.cagataycuruk.petcarebackend.controller;

import com.cagataycuruk.petcarebackend.dto.PetDto;
import com.cagataycuruk.petcarebackend.service.PetService;
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

    @PostMapping("")
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto petRequest) {
        PetDto petDto = petService.createPet(petRequest);
        return ResponseEntity.ok(petDto);
    }
}
