package com.metropolitan.it355pzback.service.impl;

import com.metropolitan.it355pzback.data.entities.Knjige;
import com.metropolitan.it355pzback.repository.KnjigeRepository;
import com.metropolitan.it355pzback.service.KnjigeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KnjigeServiceImpl implements KnjigeService {


    private final KnjigeRepository knjigeRepository;

    @Override
    public List<Knjige> findAll() {
        return knjigeRepository.findAll();
    }

    @Override
    public Page<Knjige> findAll(Pageable pageable) {
        return knjigeRepository.findAll(pageable);
    }

    @Override
    public List<Knjige> findLikeNazivOrAutorOrOpis(String kriterijum) {
        return knjigeRepository.findByNazivContainsOrAutorContainsOrOpisContains(kriterijum, kriterijum, kriterijum);
    }

    @Override
    public Optional<Knjige> findById(Integer id) {
        return knjigeRepository.findById(id);
    }

    @Override
    public List<Knjige> findByKategorijaId(int idKategorije) {
        return knjigeRepository.findByKategorija_Id(idKategorije);
    }

    @Override
    public Knjige save(Knjige knjiga) {
        return knjigeRepository.save(knjiga);
    }

    @Override
    public Knjige update(Knjige knjiga) {
        return knjigeRepository.save(knjiga);
    }

    @Override
    public void deleteById(Integer id) {
        knjigeRepository.deleteById(id);
    }
}
