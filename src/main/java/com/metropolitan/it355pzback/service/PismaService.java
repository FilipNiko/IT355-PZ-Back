package com.metropolitan.it355pzback.service;

import com.metropolitan.it355pzback.data.entities.Pisma;
import com.metropolitan.it355pzback.data.entities.Stavke;

import java.util.List;
import java.util.Optional;

public interface PismaService {

    List<Pisma> findAll();

    Optional<Pisma> findById(Integer id);


    Pisma save(Pisma pismo);

    Pisma update(Pisma pismo);

    void deleteById(Integer id);
}
