package com.docdoc.emailSender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.docdoc.emailSender.model.dto.DoctorAppointment;
import com.docdoc.emailSender.model.dto.DoctorDTO;
import com.docdoc.emailSender.model.dto.UserDTO;
import com.docdoc.emailSender.openfeign.DoctorRequest;
import com.docdoc.emailSender.openfeign.UserRequest;
import com.docdoc.emailSender.service.EmailService;

@Service(value = "notificationAppointment")
public class NotificationAppointmentServiceImpl implements EmailService<DoctorAppointment> {
    private final JavaMailSender javaMailSender;
    private final UserRequest userRequest;
    private final DoctorRequest doctorRequest;

    @Autowired
    public NotificationAppointmentServiceImpl(JavaMailSender javaMailSender, UserRequest userRequest, DoctorRequest doctorRequest) {
        this.javaMailSender = javaMailSender;
        this.userRequest = userRequest;
        this.doctorRequest = doctorRequest;
    }

    public void sendNotification(DoctorAppointment doctorAppointment) {
        UserDTO user = userRequest.getUser(doctorAppointment.getUserId()).getBody();
        DoctorDTO doctor = doctorRequest.getDoctorById(doctorAppointment.getDoctorId());
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("corporation_mail@yandex.ru");
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Doctor appointment " + doctorAppointment.getId());
        mailMessage.setText("Dear " + user.getName() + " " + user.getLastName()
                + " you have appointment to doctor " + doctor.getFirstName() + " "
        + doctor.getLastName() + " at " + doctorAppointment.getTimeFrom() +
                ". We are waiting for you at the clinic" );
        javaMailSender.send(mailMessage);
    }
}
