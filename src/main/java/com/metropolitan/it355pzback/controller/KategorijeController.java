package com.metropolitan.it355pzback.controller;


import com.metropolitan.it355pzback.data.entities.Kategorije;
import com.metropolitan.it355pzback.service.KategorijeService;
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
@RequestMapping("/api/kategorije")
public class KategorijeController {

    private KategorijeService kategorijeService;

    @GetMapping
    public ResponseEntity<List<Kategorije>> getAll() {

        return ResponseEntity.ok(kategorijeService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Kategorije> getKategorijaById(@PathVariable("id") int id) {
        Optional<Kategorije> kategorija = kategorijeService.findById(id);

        if (kategorija.isPresent()) {
            return new ResponseEntity<>(kategorija.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Kategorije> createKategorija(@RequestBody Kategorije kategorija) {
        return ResponseEntity.ok(kategorijeService.save(kategorija));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Kategorije> updateKategorija(@RequestBody Kategorije kategorija) {
        return ResponseEntity.ok(kategorijeService.update(kategorija));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteKategorija(@PathVariable("id") int id) {
        try {
            kategorijeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
