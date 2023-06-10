package com.metropolitan.it355pzback.repository;

import com.metropolitan.it355pzback.data.entities.Kategorije;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategorijeRepository extends JpaRepository<Kategorije, Integer> {
}