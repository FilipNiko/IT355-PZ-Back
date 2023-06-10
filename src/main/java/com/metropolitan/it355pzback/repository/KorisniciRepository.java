package com.metropolitan.it355pzback.repository;

import com.metropolitan.it355pzback.data.entities.Korisnici;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisniciRepository extends JpaRepository<Korisnici, Integer> {
}