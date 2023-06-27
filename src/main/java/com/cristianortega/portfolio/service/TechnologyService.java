package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

}
