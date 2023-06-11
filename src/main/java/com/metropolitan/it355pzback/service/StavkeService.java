package com.metropolitan.it355pzback.service;

import com.metropolitan.it355pzback.data.entities.Porudzbine;
import com.metropolitan.it355pzback.data.entities.Stavke;

import java.util.List;
import java.util.Optional;

public interface StavkeService {

    List<Stavke> findAll();

    Optional<Stavke> findById(Integer id);

    List<Stavke> findByIdPorudzbine(Integer id);

    Stavke save(Stavke stavka);

    Stavke update(Stavke stavka);

    void deleteById(Integer id);
}
