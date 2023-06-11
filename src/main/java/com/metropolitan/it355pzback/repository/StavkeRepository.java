package com.metropolitan.it355pzback.repository;

import com.metropolitan.it355pzback.data.entities.Stavke;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StavkeRepository extends JpaRepository<Stavke, Integer> {
    List<Stavke> findByPorudzbina_Id(Integer id);


}