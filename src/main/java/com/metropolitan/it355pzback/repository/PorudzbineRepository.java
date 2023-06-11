package com.metropolitan.it355pzback.repository;

import com.metropolitan.it355pzback.data.entities.Porudzbine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PorudzbineRepository extends JpaRepository<Porudzbine, Integer> {


    @Query("SELECT p FROM Porudzbine p ORDER BY p.id DESC")
    List<Porudzbine> findAllOrderByDescendingId();

    List<Porudzbine> findByDatumKreiranjaContainsOrPrezimeContainsOrImeContainsOrGradContainsOrAdresaContainsOrZipContainsOrBrTelefonaContainsOrStatus_StatusContainsOrKorisnik_UsernameContains(String datumKreiranja, String prezime, String ime, String grad, String adresa, String zip, String brTelefona, String status, String username);

    List<Porudzbine> findByKorisnik_Id(Integer id);




}