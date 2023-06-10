package com.metropolitan.it355pzback.service;

import com.metropolitan.it355pzback.data.entities.Knjige;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface KnjigeService {

    List<Knjige> findAll();

    Page<Knjige> findAll(Pageable pageable);

    List<Knjige> findLikeNazivOrAutorOrOpis(String kriterijum);

    Optional<Knjige> findById(Integer id);

    List<Knjige> findByKategorijaId(int idKategorije);

    Knjige save(Knjige knjiga);

    Knjige update(Knjige knjiga);

    void deleteById(Integer id);
}
