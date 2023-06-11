package com.metropolitan.it355pzback.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@Entity
@Table(name = "stavke")
public class Stavke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPorudzbine", nullable = false)
    private Porudzbine porudzbina;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idKnjige", nullable = false)
    private Knjige knjiga;

    @Column(name = "brojPrimeraka", nullable = false)
    private Integer brojPrimeraka;

}