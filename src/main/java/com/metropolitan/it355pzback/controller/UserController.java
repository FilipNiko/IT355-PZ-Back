package com.metropolitan.it355pzback.controller;


import com.metropolitan.it355pzback.repository.UserInfoProjection;
import com.metropolitan.it355pzback.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true")
@AllArgsConstructor
@RestController
@RequestMapping("/api/korisnici")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserInfoProjection> get(@PathVariable("id") int id) {
        Optional<UserInfoProjection> userInfo = userService.findProjectionById(id);

        if (userInfo.isPresent()) {
            return new ResponseEntity<>(userInfo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
