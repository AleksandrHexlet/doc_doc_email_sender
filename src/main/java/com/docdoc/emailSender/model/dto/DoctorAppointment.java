package com.docdoc.emailSender.model.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorAppointment {

    private long id;

    private LocalDateTime date;

    private LocalTime timeTo;


    private LocalTime timeFrom;

    private long doctorId;


    private long clinicId;

    private long userId;

    private Double price;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;

    public enum AppointmentStatus {
        NEW,
        APPOINTMENT_COMPLETED,
        DOCTOR_CANCELLED,
        PATIENT_CANCELED,
        CANCELLED
    }
}


