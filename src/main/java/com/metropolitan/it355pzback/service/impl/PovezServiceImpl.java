package com.metropolitan.it355pzback.service.impl;


import com.metropolitan.it355pzback.data.entities.Povez;
import com.metropolitan.it355pzback.repository.PovezRepository;
import com.metropolitan.it355pzback.service.PovezService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PovezServiceImpl implements PovezService {

    private final PovezRepository povezRepository;


    @Override
    public List<Povez> findAll() {
        return povezRepository.findAll();
    }

    @Override
    public Optional<Povez> findById(Integer id) {
        return povezRepository.findById(id);
    }

    @Override
    public Povez save(Povez povez) {
        return povezRepository.save(povez);
    }

    @Override
    public Povez update(Povez povez) {
        return povezRepository.save(povez);
    }

    @Override
    public void deleteById(Integer id) {
        povezRepository.deleteById(id);
    }
}
