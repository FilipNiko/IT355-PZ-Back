package com.metropolitan.it355pzback.controller;


import com.metropolitan.it355pzback.data.entities.Povez;
import com.metropolitan.it355pzback.service.PovezService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true")
@AllArgsConstructor
@RestController
@RequestMapping("/api/povez")
public class PovezController {

    private final PovezService povezService;

    @GetMapping
    public ResponseEntity<List<Povez>> getAll() {
        return ResponseEntity.ok(povezService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Povez> getPovezById(@PathVariable("id") int id) {
        Optional<Povez> povez = povezService.findById(id);

        if (povez.isPresent()) {
            return new ResponseEntity<>(povez.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Povez> createPovez(@RequestBody Povez povez) {
        return ResponseEntity.ok(povezService.save(povez));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Povez> updatePovez(@RequestBody Povez povez) {
        return ResponseEntity.ok(povezService.update(povez));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deletePovez(@PathVariable("id") int id) {
        try {
            povezService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
