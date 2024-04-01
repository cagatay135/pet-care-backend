package com.cagataycuruk.petcarebackend.enums;

public enum EventType {
    VACCINE("Vaccine"),
    CLINIC_VISIT("Clinic Visit"),
    MEDICINE("Medicine");

    private final String eventType;

    EventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}