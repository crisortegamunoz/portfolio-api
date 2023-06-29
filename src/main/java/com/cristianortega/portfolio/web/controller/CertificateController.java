package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.service.CertificateDTOService;
import com.cristianortega.portfolio.persistence.entity.Certificate;
import com.cristianortega.portfolio.service.CertificateService;
import com.cristianortega.portfolio.domain.dto.CertificateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateDTOService certificateDTOService;
    private final CertificateService certificateService;

    @Autowired
    public CertificateController(CertificateDTOService certificateDTOService, CertificateService certificateService) {
        this.certificateDTOService = certificateDTOService;
        this.certificateService = certificateService;
    }

    @GetMapping
    public ResponseEntity<List<Certificate>> getAll() {
        return this.certificateService.getAll()
                .map(certificates -> new ResponseEntity<>(certificates, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CertificateDTO> save(@RequestBody CertificateDTO certificate) {
        if (certificate.getId() == null || !this.certificateService.exists(certificate.getId())) {
            return this.certificateDTOService.save(certificate)
                    .map(certificateSaved -> new ResponseEntity<>(certificateSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<CertificateDTO> update(@RequestBody CertificateDTO certificate) {
        if (certificate.getId() != null && this.certificateService.exists(certificate.getId())) {
            return this.certificateDTOService.save(certificate)
                    .map(certificateSaved -> new ResponseEntity<>(certificateSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.certificateService.exists(id)) {
            this.certificateService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
