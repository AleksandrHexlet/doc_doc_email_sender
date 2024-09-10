package com.docdoc.emailSender.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.docdoc.emailSender.model.dto.DoctorDTO;


@FeignClient(value = "userService", url = "http://localhost:8080/cad/doctor")
public interface DoctorRequest {
    @GetMapping("/{id}")
    DoctorDTO getDoctorById(@PathVariable long id);
}


