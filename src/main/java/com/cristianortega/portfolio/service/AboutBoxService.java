package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.repository.AboutBoxRepository;
import org.springframework.stereotype.Service;

@Service
public class AboutBoxService {

    private final AboutBoxRepository aboutBoxRepository;

    public AboutBoxService(AboutBoxRepository aboutBoxRepository) {
        this.aboutBoxRepository = aboutBoxRepository;
    }

}
