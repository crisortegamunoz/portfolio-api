package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Certificate;
import com.cristianortega.portfolio.persistence.repository.CertificateRepository;
import com.cristianortega.portfolio.persistence.repository.pagination.CertificatePageSortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateService {

    private final CertificateRepository certificateRepository;
    private final CertificatePageSortRepository certificatePageSortRepository;

    @Autowired
    public CertificateService(CertificateRepository certificateRepository,
                              CertificatePageSortRepository certificatePageSortRepository) {
        this.certificateRepository = certificateRepository;
        this.certificatePageSortRepository = certificatePageSortRepository;
    }
    public Page<Certificate> getAll(Pageable pageRequest) {
        return this.certificatePageSortRepository.findAll(pageRequest);
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
    public Optional<Certificate> getById(Integer id) {
        return certificateRepository.findById(id);
    }
    public void delete(Integer id) {
        this.certificateRepository.deleteById(id);
    }
    public boolean exists(Integer id) {
        return this.certificateRepository.existsById(id);
    }
    public Page<Certificate> getByCategory(Pageable pageRequest, int idCategory) {
        return this.certificatePageSortRepository.findAllByIdCategory(pageRequest, idCategory);
    }

}
