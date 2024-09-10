package com.docdoc.emailSender.service.impl;

import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import com.docdoc.emailSender.model.dto.ClinicDTO;
import com.docdoc.emailSender.model.dto.UserDTO;
import com.docdoc.emailSender.openfeign.UserRequest;
import com.docdoc.emailSender.service.EmailService;

@Service(value = "notificationAboutNewClinic")
public class SendInfoNewClinic implements EmailService<ClinicDTO> {
    private final JavaMailSender mailSender;
    private final UserRequest userRequest;

    public SendInfoNewClinic(JavaMailSender mailSender, UserRequest userRequest) {
        this.mailSender = mailSender;
        this.userRequest = userRequest;
    }

    @Override
    public void sendNotification(ClinicDTO dataToSend) throws MessagingException {
        List<UserDTO> userList = userRequest.getAllUsersByCity("Moscow").getBody();

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);

        messageHelper.setTo(userList.stream().map(userDTO -> userDTO.getEmail()).toArray(String[]::new));
        messageHelper.setFrom("corporation_mail@yandex.ru");
        messageHelper.setText("Dear user new clinic to "+ dataToSend.getAddress());
        FileSystemResource fileSystemResource = new FileSystemResource("/path/to/image");
        messageHelper.addAttachment("foto new Clinic", fileSystemResource);

        mailSender.send(message);
    }
}
