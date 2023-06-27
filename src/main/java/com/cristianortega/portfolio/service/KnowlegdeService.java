package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Knowlegde;
import com.cristianortega.portfolio.persistence.repository.KnowlegdeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KnowlegdeService {

    private final KnowlegdeRepository knowlegdeRepository;

    public KnowlegdeService(KnowlegdeRepository knowlegdeRepository) {
        this.knowlegdeRepository = knowlegdeRepository;
    }

    public Optional<List<Knowlegde>> getAll() {
        return Optional.of(knowlegdeRepository.findAll());
    }

    public Optional<Knowlegde> save(Knowlegde knowlegde) {
        return Optional.of(knowlegdeRepository.save(knowlegde));
    }

    public Optional<Knowlegde> update(Knowlegde knowlegde) {
        if (exists(knowlegde.getIdKnowlegde())) {
            return Optional.of(knowlegdeRepository.save(knowlegde));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Knowlegde> findById(Integer id) {
        return knowlegdeRepository.findById(id);
    }

    public void delete(Integer id) {
        this.knowlegdeRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.knowlegdeRepository.existsById(id);
    }

}
