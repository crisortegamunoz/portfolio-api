package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.repository.CertificateRepository;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;

    public CertificateService(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }
}
