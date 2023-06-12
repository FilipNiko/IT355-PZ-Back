package com.metropolitan.it355pzback.controller;

import com.metropolitan.it355pzback.data.entities.Knjige;
import com.metropolitan.it355pzback.data.entities.Porudzbine;
import com.metropolitan.it355pzback.data.entities.Stavke;
import com.metropolitan.it355pzback.service.PorudzbineService;
import com.metropolitan.it355pzback.service.StavkeService;
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
@RequestMapping("/api/stavke")
public class StavkeController {

    private final StavkeService stavkeService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Stavke>> getAll() {
        return ResponseEntity.ok(stavkeService.findAll());
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Stavke> getStavkaById(@PathVariable("id") int id) {
        Optional<Stavke> stavka = stavkeService.findById(id);

        if (stavka.isPresent()) {
            return new ResponseEntity<>(stavka.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search/porudzbina")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Stavke>> findByPorudzbinaId(@RequestParam(value = "_porudzbinaId") int idPorudzbine) {
        try {
            List<Stavke> stavke = stavkeService.findByIdPorudzbine(idPorudzbine);

            if (stavke.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(stavke, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Stavke> createStavka(@RequestBody Stavke stavka) {
        return ResponseEntity.ok(stavkeService.save(stavka));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Stavke> updateStavka(@RequestBody Stavke stavka) {
        return ResponseEntity.ok(stavkeService.update(stavka));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteStavka(@PathVariable("id") int id) {
        try {
            stavkeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
