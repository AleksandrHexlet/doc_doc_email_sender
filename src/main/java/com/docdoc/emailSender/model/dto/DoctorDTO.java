package com.docdoc.emailSender.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorDTO {
    private long doctorId;

    private String firstName;

    private String patronymic;

    private String lastName;

    private List<String> category;

    private int experience;

    private String description;

    private String login;

    private String password;

    private String city;

    private boolean isActive;

    private boolean isChild;
    private boolean isHome;
}






