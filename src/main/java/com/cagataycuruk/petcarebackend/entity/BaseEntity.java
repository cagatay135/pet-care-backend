package com.cagataycuruk.petcarebackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "created_date")
    protected LocalDateTime createdDate;


    @Column(name = "updated_date")
    protected LocalDateTime updatedDate;

    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;

    private boolean deleted = false;

    @PrePersist
    private void prePersist() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}