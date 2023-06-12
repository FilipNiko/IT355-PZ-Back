package com.metropolitan.it355pzback.controller;

import com.metropolitan.it355pzback.data.entities.Pisma;
import com.metropolitan.it355pzback.data.entities.Povez;
import com.metropolitan.it355pzback.service.PismaService;
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
@RequestMapping("/api/pisma")
public class PismaController {

    private final PismaService pismaService;

    @GetMapping
    public ResponseEntity<List<Pisma>> getAll() {
        return ResponseEntity.ok(pismaService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pisma> getPismoById(@PathVariable("id") int id) {
        Optional<Pisma> pismo = pismaService.findById(id);

        if (pismo.isPresent()) {
            return new ResponseEntity<>(pismo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pisma> createPismo(@RequestBody Pisma pismo) {
        return ResponseEntity.ok(pismaService.save(pismo));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pisma> updatePismo(@RequestBody Pisma pismo) {
        return ResponseEntity.ok(pismaService.update(pismo));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deletePismo(@PathVariable("id") int id) {
        try {
            pismaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
