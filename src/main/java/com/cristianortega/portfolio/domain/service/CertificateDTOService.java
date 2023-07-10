package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.CertificateDTO;
import com.cristianortega.portfolio.domain.mapper.CertificateMapper;
import com.cristianortega.portfolio.domain.util.PageConvert;
import com.cristianortega.portfolio.persistence.entity.Certificate;
import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
import com.cristianortega.portfolio.service.CertificateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Optional<Page<CertificateDTO>> getAll(int pages, int elements, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageRequest = PageRequest.of(pages, elements, sort);
        Optional<Page<Certificate>> pageOptional = Optional.ofNullable(this.certificateService.getAll(pageRequest));
        return pageOptional.map(page -> PageConvert.convertPage(page, CertificateMapper.INSTANCE.toCertificatesDTO(page.getContent())));
    }

    public Optional<CertificateDTO> save(CertificateDTO certificateDTO) {
        return this.certificateService.save(CertificateMapper.INSTANCE.toCertificate(certificateDTO))
                .map(CertificateMapper.INSTANCE::toCertificateDTO);
    }

    public Optional<CertificateDTO> getById(int id) {
        return this.certificateService.getById(id).map(CertificateMapper.INSTANCE::toCertificateDTO);
    }

}
