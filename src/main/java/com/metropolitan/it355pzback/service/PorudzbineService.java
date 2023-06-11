package com.metropolitan.it355pzback.service;

import com.metropolitan.it355pzback.data.entities.Kategorije;
import com.metropolitan.it355pzback.data.entities.Porudzbine;

import java.util.List;
import java.util.Optional;

public interface PorudzbineService {

    List<Porudzbine> findAll();

    List<Porudzbine> findAllOrderDescById();

    List<Porudzbine> findByAllCriteria(String kriterijum);

    Optional<Porudzbine> findById(Integer id);

    List<Porudzbine> findByIdKorisnika(Integer id);

    Porudzbine save(Porudzbine porudzbine);

    Porudzbine update(Porudzbine porudzbine);

    void deleteById(Integer id);
}
