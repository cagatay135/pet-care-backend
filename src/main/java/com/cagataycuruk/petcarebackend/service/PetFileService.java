package com.cagataycuruk.petcarebackend.service;

import com.cagataycuruk.petcarebackend.dto.PetFileDto;
import com.cagataycuruk.petcarebackend.entity.Pet;
import com.cagataycuruk.petcarebackend.entity.PetFile;
import com.cagataycuruk.petcarebackend.enums.FileType;
import com.cagataycuruk.petcarebackend.mapper.PetFileMapper;
import com.cagataycuruk.petcarebackend.mapper.PetMapper;
import com.cagataycuruk.petcarebackend.repository.PetFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PetFileService {
    private final S3Service s3Service;
    private final PetFileRepository petFileRepository;
    private final PetService petService;
    private final PetMapper petMapper;
    private final PetFileMapper petFileMapper;

    public PetFileService(S3Service s3Service, PetFileRepository petFileRepository, PetService petService, PetMapper petMapper, PetFileMapper petFileMapper) {
        this.s3Service = s3Service;
        this.petFileRepository = petFileRepository;
        this.petService = petService;
        this.petMapper = petMapper;
        this.petFileMapper = petFileMapper;
    }

    public PetFileDto uploadPetFile(UUID petId, MultipartFile multipartFile, FileType fileType) throws IOException {
        Pet pet = petMapper.toPetEntity(petService.getPetById(petId));

        String fileUrl = s3Service.uploadFile(multipartFile);

        PetFile petFile = savePetFile(pet, fileUrl, fileType);

        return PetFileDto.builder()
                .petId(pet.getId())
                .fileUrl(petFile.getFileUrl())
                .fileType(fileType)
                .build();
    }

    private PetFile savePetFile(Pet pet, String fileUrl, FileType fileType){
        PetFile petFile = PetFile.builder()
                .fileUrl(fileUrl)
                .pet(pet)
                .fileType(fileType)
                .build();
        return petFileRepository.save(petFile);
    }

    public List<PetFileDto> getPetFilesByType(UUID petId, FileType fileType) {
        Pet pet = petMapper.toPetEntity(petService.getPetById(petId));

        List<PetFile> petFiles= petFileRepository.findAllByPetAndFileTypeOrderByCreatedDateDesc(pet, fileType);

        return petFiles.stream()
                .map(petFileMapper::toPetFileDto)
                .collect(Collectors.toList());
    }
}
