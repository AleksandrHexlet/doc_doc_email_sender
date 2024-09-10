package com.docdoc.emailSender.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class UserDTO {
    private long id;

    private String name;

    private String lastName;

    private String login;

    private String password;
    private String phone;
    private String email;

    private String metroStationName;

    private String areaName;
    private String city;
}
