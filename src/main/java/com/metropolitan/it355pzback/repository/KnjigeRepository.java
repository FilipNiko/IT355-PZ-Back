package com.metropolitan.it355pzback.repository;

import com.metropolitan.it355pzback.data.entities.Knjige;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnjigeRepository extends JpaRepository<Knjige, Integer> {


    Page<Knjige> findAll(Pageable pageable);

    List<Knjige> findByNazivContainsOrAutorContainsOrOpisContains(String naziv, String autor, String opis);

    List<Knjige> findByKategorija_Id(Integer id);







}