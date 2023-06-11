package com.metropolitan.it355pzback.service;

import com.metropolitan.it355pzback.data.entities.Pisma;
import com.metropolitan.it355pzback.data.entities.Povez;

import java.util.List;
import java.util.Optional;

public interface PovezService {

    List<Povez> findAll();

    Optional<Povez> findById(Integer id);


    Povez save(Povez povez);

    Povez update(Povez povez);

    void deleteById(Integer id);
}
