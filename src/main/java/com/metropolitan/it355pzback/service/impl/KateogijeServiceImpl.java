package com.metropolitan.it355pzback.service.impl;

import com.metropolitan.it355pzback.data.entities.Kategorije;
import com.metropolitan.it355pzback.repository.KategorijeRepository;
import com.metropolitan.it355pzback.service.KategorijeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KateogijeServiceImpl implements KategorijeService {

    private final KategorijeRepository kategorijeRepository;
    @Override
    public List<Kategorije> findAll() {
        return kategorijeRepository.findAll();
    }

    @Override
    public Optional<Kategorije> findById(Integer id) {
        return kategorijeRepository.findById(id);
    }

    @Override
    public Kategorije save(Kategorije kategorije) {
        return kategorijeRepository.save(kategorije);
    }

    @Override
    public Kategorije update(Kategorije kategorije) {
        return kategorijeRepository.save(kategorije);
    }

    @Override
    public void deleteById(Integer id) {
        kategorijeRepository.deleteById(id);
    }
}
