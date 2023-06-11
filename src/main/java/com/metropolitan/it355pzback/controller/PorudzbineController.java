package com.metropolitan.it355pzback.controller;

import com.metropolitan.it355pzback.data.entities.Kategorije;
import com.metropolitan.it355pzback.data.entities.Knjige;
import com.metropolitan.it355pzback.data.entities.Porudzbine;
import com.metropolitan.it355pzback.data.entities.Stavke;
import com.metropolitan.it355pzback.service.PorudzbineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true")
@AllArgsConstructor
@RestController
@RequestMapping("/api/porudzbine")
public class PorudzbineController {

    private final PorudzbineService porudzbineService;

    @GetMapping
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Porudzbine>> getAll() {
        return ResponseEntity.ok(porudzbineService.findAll());
    }

    @GetMapping("/orderDesc")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Porudzbine>> getAllDesc() {
        return ResponseEntity.ok(porudzbineService.findAllOrderDescById());
    }


    @GetMapping("/search")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Porudzbine>> findByAllCriteria(@RequestParam(value = "_q") String kriterijum) {
        try {
            List<Porudzbine> porudzbine = porudzbineService.findByAllCriteria(kriterijum);

            if (porudzbine.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(porudzbine, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Porudzbine> getKPorudzbinaById(@PathVariable("id") int id) {
        Optional<Porudzbine> porudzbina = porudzbineService.findById(id);

        if (porudzbina.isPresent()) {
            return new ResponseEntity<>(porudzbina.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/search/korisnik")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Porudzbine>> findByKorisnikId(@RequestParam(value = "_korisnikId") int idKorisnika) {
        try {
            List<Porudzbine> porudzbine = porudzbineService.findByIdKorisnika(idKorisnika);

            if (porudzbine.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(porudzbine, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Porudzbine> createPorudzbina(@RequestBody Porudzbine porudzbina) {
        return ResponseEntity.ok(porudzbineService.save(porudzbina));
    }

    @PutMapping
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Porudzbine> updatePorudzbina(@RequestBody Porudzbine porudzbina) {
        return ResponseEntity.ok(porudzbineService.update(porudzbina));
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deletePorudzbina(@PathVariable("id") int id) {
        try {
            porudzbineService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
