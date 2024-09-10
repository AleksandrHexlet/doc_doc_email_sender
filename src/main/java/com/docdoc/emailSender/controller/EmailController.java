package com.docdoc.emailSender.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.mail.MessagingException;

import com.docdoc.emailSender.model.dto.ClinicDTO;
import com.docdoc.emailSender.model.dto.DoctorAppointment;
import com.docdoc.emailSender.service.EmailService;

@RestController
@RequestMapping("/notification")
public class EmailController {
    private final EmailService<DoctorAppointment> notificationAppointmentService;
    private final EmailService<ClinicDTO> notificationNewClinic;

    public EmailController(@Qualifier(value = "notificationAppointment") EmailService<DoctorAppointment> notificationAppointmentService,
                           @Qualifier(value = "notificationAboutNewClinic") EmailService<ClinicDTO> notificationNewClinic) {
        this.notificationAppointmentService = notificationAppointmentService;
        this.notificationNewClinic = notificationNewClinic;
    }

    @PostMapping("/appointment")
    public void getDoctorAppointment(@RequestBody DoctorAppointment doctorAppointment) {
        try {
            notificationAppointmentService.sendNotification(doctorAppointment);
        } catch (MessagingException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }

    }

    @PostMapping("/new/clinic")
    public void sendInfoNewClinic(@RequestBody ClinicDTO clinicDTO) throws MessagingException {
        try {
            notificationNewClinic.sendNotification(clinicDTO);
        } catch (MessagingException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }
}