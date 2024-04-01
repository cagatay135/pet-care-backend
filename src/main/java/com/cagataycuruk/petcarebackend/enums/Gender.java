package com.cagataycuruk.petcarebackend.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNKOWN("Unkown");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}