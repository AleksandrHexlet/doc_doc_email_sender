package com.docdoc.emailSender.service;

import jakarta.mail.MessagingException;

import com.docdoc.emailSender.model.dto.ClinicDTO;

public interface EmailService<T> {
    void sendNotification(T dataToSend) throws MessagingException;
}
