package com.cagataycuruk.petcarebackend.controller;

import com.cagataycuruk.petcarebackend.dto.PetDto;
import com.cagataycuruk.petcarebackend.dto.PetFileDto;
import com.cagataycuruk.petcarebackend.dto.request.CreatePetRequest;
import com.cagataycuruk.petcarebackend.dto.request.UpdatePetRequest;
import com.cagataycuruk.petcarebackend.enums.FileType;
import com.cagataycuruk.petcarebackend.service.PetFileService;
import com.cagataycuruk.petcarebackend.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/pets")
public class PetController {
    private final PetService petService;
    private final PetFileService petFileService;

    public PetController(PetService petService, PetFileService petFileService) {
        this.petService = petService;
        this.petFileService = petFileService;
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

    @PostMapping(path = "/{petId}/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PetFileDto> uploadFile(@PathVariable UUID petId,
                                                 @RequestParam("file") MultipartFile file,
                                                 @RequestParam("fileType") FileType fileType) throws IOException {
        PetFileDto petFileDto = petFileService.uploadPetFile(petId, file, fileType);
        return ResponseEntity.ok(petFileDto);
    }
}
