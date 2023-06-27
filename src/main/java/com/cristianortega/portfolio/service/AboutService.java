package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.repository.AboutRepository;
import org.springframework.stereotype.Service;
@Service
public class AboutService {

    private final AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }
}
