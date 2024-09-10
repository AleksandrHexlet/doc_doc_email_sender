package com.docdoc.emailSender.model.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClinicDTO {
    private long clinicId;
    private String name;
    private String address;
    private int cityId;
    private int phoneNumber;
    private String description;
}
