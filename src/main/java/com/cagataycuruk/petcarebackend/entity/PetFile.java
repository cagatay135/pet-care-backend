package com.cagataycuruk.petcarebackend.entity;

import com.cagataycuruk.petcarebackend.enums.FileType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pet_file")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetFile extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(fetch= FetchType.LAZY)
    private Pet pet;

    @Column(name = "file_url")
    private String fileUrl;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    private String description;
}