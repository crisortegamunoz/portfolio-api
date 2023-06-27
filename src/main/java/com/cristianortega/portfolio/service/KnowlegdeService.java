package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.repository.KnowlegdeRepository;
import org.springframework.stereotype.Service;

@Service
public class KnowlegdeService {

    private final KnowlegdeRepository knowlegdeRepository;

    public KnowlegdeService(KnowlegdeRepository knowlegdeRepository) {
        this.knowlegdeRepository = knowlegdeRepository;
    }

}
