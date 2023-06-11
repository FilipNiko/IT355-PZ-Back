package com.metropolitan.it355pzback.service.impl;

import com.metropolitan.it355pzback.data.entities.Pisma;
import com.metropolitan.it355pzback.repository.PismaRepository;
import com.metropolitan.it355pzback.service.PismaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PismaServiceImpl implements PismaService {

    private final PismaRepository pismaRepository;

    @Override
    public List<Pisma> findAll() {
        return pismaRepository.findAll();
    }

    @Override
    public Optional<Pisma> findById(Integer id) {
        return pismaRepository.findById(id);
    }

    @Override
    public Pisma save(Pisma pismo) {
        return pismaRepository.save(pismo);
    }

    @Override
    public Pisma update(Pisma pismo) {
        return pismaRepository.save(pismo);
    }

    @Override
    public void deleteById(Integer id) {
        pismaRepository.deleteById(id);
    }
}
