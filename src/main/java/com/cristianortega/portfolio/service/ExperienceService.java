package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Experience;
import com.cristianortega.portfolio.persistence.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public Optional<List<Experience>> getAll() {
        return Optional.of(experienceRepository.findAll());
    }

    public Optional<Experience> save(Experience experience) {
        return Optional.of(experienceRepository.save(experience));
    }

    public Optional<Experience> update(Experience experience) {
        if (exists(experience.getIdExperience())) {
            return Optional.of(experienceRepository.save(experience));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Experience> getById(Integer id) {
        return experienceRepository.findById(id);
    }

    public void delete(Integer id) {
        this.experienceRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.experienceRepository.existsById(id);
    }

}
