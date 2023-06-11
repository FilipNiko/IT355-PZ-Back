package com.metropolitan.it355pzback.controller;


import com.metropolitan.it355pzback.data.entities.Knjige;
import com.metropolitan.it355pzback.service.KnjigeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials = "true")
@AllArgsConstructor
@RestController
@RequestMapping("/api/knjige")
public class KnjigeController {

    private KnjigeService knjigeService;

    @GetMapping
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Knjige>> getAll() {

        return ResponseEntity.ok(knjigeService.findAll());
    }

    @GetMapping("/limited")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Knjige>> getLimited(@RequestParam(value = "_limit", defaultValue = "4") int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        List<Knjige> limitedKnjige = knjigeService.findAll(pageable).getContent();
        return ResponseEntity.ok(limitedKnjige);
    }

    @GetMapping("/search")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Knjige>> findByAllCriteria(@RequestParam(value = "_q") String kriterijum) {
        try {
            List<Knjige> knjige = knjigeService.findLikeNazivOrAutorOrOpis(kriterijum);

            if (knjige.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(knjige, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/kategorija")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Knjige>> findByKategorijaId(@RequestParam(value = "_kategorijaId") int idKategorije) {
        try {
            List<Knjige> knjige = knjigeService.findByKategorijaId(idKategorije);

            if (knjige.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(knjige, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Knjige> getKnjigaById(@PathVariable("id") int id) {
        Optional<Knjige> knjiga = knjigeService.findById(id);

        if (knjiga.isPresent()) {
            return new ResponseEntity<>(knjiga.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Knjige> createKnjiga(@RequestBody Knjige knjiga) {
        return ResponseEntity.ok(knjigeService.save(knjiga));
    }

    @PutMapping
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Knjige> updateKnjiga(@RequestBody Knjige knjiga) {
        return ResponseEntity.ok(knjigeService.update(knjiga));
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> deleteKnjiga(@PathVariable("id") int id) {
        try {
            knjigeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
