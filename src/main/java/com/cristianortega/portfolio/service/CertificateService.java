package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Certificate;
import com.cristianortega.portfolio.persistence.entity.Experience;
import com.cristianortega.portfolio.persistence.repository.CertificateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;

    public CertificateService(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    public Optional<List<Certificate>> getAll() {
        return Optional.of(certificateRepository.findAll());
    }

    public Optional<Certificate> save(Certificate certificate) {
        return Optional.of(certificateRepository.save(certificate));
    }

    public Optional<Certificate> update(Certificate certificate) {
        if (exists(certificate.getIdCertificate())) {
            return Optional.of(certificateRepository.save(certificate));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Certificate> findById(Integer id) {
        return certificateRepository.findById(id);
    }

    public void delete(Integer id) {
        this.certificateRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.certificateRepository.existsById(id);
    }

}
