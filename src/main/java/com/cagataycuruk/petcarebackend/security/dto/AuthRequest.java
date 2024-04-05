package com.cagataycuruk.petcarebackend.security.dto;

public record AuthRequest (
        String username,
        String password
){
}