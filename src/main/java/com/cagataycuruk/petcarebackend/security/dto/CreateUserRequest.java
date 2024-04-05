package com.cagataycuruk.petcarebackend.security.dto;

import com.cagataycuruk.petcarebackend.security.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public record CreateUserRequest(
        String name,
        String username,
        String password,
        Set<Role> authorities
){
}