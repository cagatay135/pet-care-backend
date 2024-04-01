package com.cagataycuruk.petcarebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "pet_photo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
public class PetPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Pet pet;

    @Column(name = "photo_url")
    private String photoUrl;

    private String description;
}