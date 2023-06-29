package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Technology;
import com.cristianortega.portfolio.persistence.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public Optional<List<Technology>> getAll() {
        return Optional.of(technologyRepository.findAll());
    }

    public Optional<Technology> save(Technology technology) {
        return Optional.of(technologyRepository.save(technology));
    }

    public Optional<Technology> update(Technology technology) {
        if (exists(technology.getIdTechnology())) {
            return Optional.of(technologyRepository.save(technology));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Technology> getById(Integer id) {
        return technologyRepository.findById(id);
    }

    public void delete(Integer id) {
        this.technologyRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.technologyRepository.existsById(id);
    }

}
