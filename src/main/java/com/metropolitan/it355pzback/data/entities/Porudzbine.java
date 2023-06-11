package com.metropolitan.it355pzback.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@Entity
@Table(name = "porudzbine")
public class Porudzbine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "datumKreiranja", nullable = false)
    private String datumKreiranja;

    @Column(name = "ime", nullable = false, length = 50)
    private String ime;

    @Column(name = "prezime", nullable = false, length = 50)
    private String prezime;

    @Column(name = "grad", nullable = false, length = 50)
    private String grad;

    @Column(name = "adresa", nullable = false, length = 50)
    private String adresa;

    @Column(name = "zip", nullable = false, length = 50)
    private String zip;

    @Column(name = "brTelefona", nullable = false, length = 30)
    private String brTelefona;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idStatusa", nullable = false)
    private Statusi status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idKorisnika", nullable = false)
    private Korisnici korisnik;

   /* @OneToMany(mappedBy = "porudzbina")
    private List<Stavke> stavke = new ArrayList<>();*/

}