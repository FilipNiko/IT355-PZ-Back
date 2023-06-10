package com.metropolitan.it355pzback.service;

import com.metropolitan.it355pzback.data.entities.Kategorije;

import java.util.List;
import java.util.Optional;

public interface KategorijeService {

    List<Kategorije> findAll();

    Optional<Kategorije> findById(Integer id);

    Kategorije save(Kategorije kategorije);

    Kategorije update(Kategorije game);

    void deleteById(Integer id);
}
