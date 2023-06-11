package com.metropolitan.it355pzback.service.impl;

import com.metropolitan.it355pzback.data.entities.Porudzbine;
import com.metropolitan.it355pzback.repository.PorudzbineRepository;
import com.metropolitan.it355pzback.service.PorudzbineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PorudzbineServiceImpl implements PorudzbineService {

    private final PorudzbineRepository porudzbineRepository;

    @Override
    public List<Porudzbine> findAll() {
        return porudzbineRepository.findAll();
    }

    @Override
    public List<Porudzbine> findAllOrderDescById() {
        return porudzbineRepository.findAllOrderByDescendingId();
    }

    @Override
    public List<Porudzbine> findByAllCriteria(String kriterijum) {
        return porudzbineRepository.findByDatumKreiranjaContainsOrPrezimeContainsOrImeContainsOrGradContainsOrAdresaContainsOrZipContainsOrBrTelefonaContainsOrStatus_StatusContainsOrKorisnik_UsernameContains(kriterijum, kriterijum, kriterijum, kriterijum, kriterijum, kriterijum, kriterijum, kriterijum, kriterijum);
    }

    @Override
    public Optional<Porudzbine> findById(Integer id) {
        return porudzbineRepository.findById(id);
    }

    @Override
    public List<Porudzbine> findByIdKorisnika(Integer id) {
        return porudzbineRepository.findByKorisnik_Id(id);
    }

    @Override
    public Porudzbine save(Porudzbine porudzbine) {
        return porudzbineRepository.save(porudzbine);
    }

    @Override
    public Porudzbine update(Porudzbine porudzbine) {
        return porudzbineRepository.save(porudzbine);
    }

    @Override
    public void deleteById(Integer id) {
        porudzbineRepository.deleteById(id);
    }
}
