package com.metropolitan.it355pzback.service.impl;


import com.metropolitan.it355pzback.data.entities.Stavke;
import com.metropolitan.it355pzback.repository.StavkeRepository;
import com.metropolitan.it355pzback.service.StavkeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StavkeServiceImpl implements StavkeService {


    private final StavkeRepository stavkeRepository;


    @Override
    public List<Stavke> findAll() {
        return stavkeRepository.findAll();
    }

    @Override
    public Optional<Stavke> findById(Integer id) {
        return stavkeRepository.findById(id);
    }

    @Override
    public List<Stavke> findByIdPorudzbine(Integer id) {
        return stavkeRepository.findByPorudzbina_Id(id);
    }

    @Override
    public Stavke save(Stavke stavka) {
        return stavkeRepository.save(stavka);
    }

    @Override
    public Stavke update(Stavke stavka) {
        return stavkeRepository.save(stavka);
    }

    @Override
    public void deleteById(Integer id) {
        stavkeRepository.findById(id);

    }
}
