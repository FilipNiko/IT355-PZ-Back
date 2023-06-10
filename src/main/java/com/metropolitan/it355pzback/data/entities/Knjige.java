package com.metropolitan.it355pzback.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@Entity
@Table(name = "knjige")
public class Knjige {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "naziv", nullable = false, length = 100)
    private String naziv;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @Lob
    @Column(name = "opis", nullable = false)
    private String opis;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPisma", nullable = false)
    private Pisma pismo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPoveza", nullable = false)
    private Povez povez;

    @Column(name = "brojStrana", nullable = false)
    private Integer brojStrana;

    @Column(name = "stanje", nullable = false)
    private Integer stanje;

    @Lob
    @Column(name = "slikaUrl", nullable = false)
    private String slikaUrl;

    @Column(name = "cena", nullable = false)
    private Integer cena;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idKategorije", nullable = false)
    private Kategorije kategorija;

}