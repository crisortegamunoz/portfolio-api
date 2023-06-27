package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

}
