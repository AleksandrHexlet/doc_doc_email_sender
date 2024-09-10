package com.docdoc.emailSender.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.docdoc.emailSender.model.dto.UserDTO;


@FeignClient(value = "userService", url = "http://localhost:8080/user")
public interface UserRequest {
    @PostMapping("/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable Long id);

    @PostMapping("/city/users")
    ResponseEntity<List<UserDTO>> getAllUsersByCity(@RequestParam String city);
}
