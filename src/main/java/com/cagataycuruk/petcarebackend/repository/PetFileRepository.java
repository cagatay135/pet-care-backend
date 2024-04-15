package com.cagataycuruk.petcarebackend.repository;

import com.cagataycuruk.petcarebackend.entity.Pet;
import com.cagataycuruk.petcarebackend.entity.PetFile;
import com.cagataycuruk.petcarebackend.enums.FileType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PetFileRepository extends JpaRepository<PetFile, UUID> {
    List<PetFile> findAllByPetAndFileTypeOrderByCreatedDateDesc(Pet pet, FileType fileType);
}