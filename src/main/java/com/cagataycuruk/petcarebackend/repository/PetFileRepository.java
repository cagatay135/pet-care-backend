package com.cagataycuruk.petcarebackend.repository;

import com.cagataycuruk.petcarebackend.entity.PetFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PetFileRepository extends JpaRepository<PetFile, UUID> {
}