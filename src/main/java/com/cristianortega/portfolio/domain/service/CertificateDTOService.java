package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.CertificateDTO;
import com.cristianortega.portfolio.domain.mapper.CertificateMapper;
import com.cristianortega.portfolio.service.CertificateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateDTOService {

    private final CertificateService certificateService;

    public CertificateDTOService(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    public Optional<List<CertificateDTO>> getAll() {
        List<CertificateDTO> array = new ArrayList<>(0);
        this.certificateService.getAll().ifPresent(certificates -> {
            array.addAll(CertificateMapper.INSTANCE.toCertificatesDTO(certificates));
        });
        return Optional.of(array);
    }

    public Optional<CertificateDTO> save(CertificateDTO certificateDTO) {
        return this.certificateService.save(CertificateMapper.INSTANCE.toCertificate(certificateDTO))
                .map(CertificateMapper.INSTANCE::toCertificateDTO);
    }

    public Optional<CertificateDTO> getById(int id) {
        return this.certificateService.getById(id).map(CertificateMapper.INSTANCE::toCertificateDTO);
    }
}
