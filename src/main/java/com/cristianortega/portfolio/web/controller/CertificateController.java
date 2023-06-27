package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.persistence.entity.Certificate;
import com.cristianortega.portfolio.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;
    @Autowired
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping
    public ResponseEntity<List<Certificate>> getAll() {
        return this.certificateService.getAll()
                .map(certificates -> new ResponseEntity<>(certificates, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Certificate> save(@RequestBody Certificate certificate) {
        if (certificate.getIdCertificate()== null || !this.certificateService.exists(certificate.getIdCertificate())) {
            return this.certificateService.save(certificate)
                    .map(certificateSaved -> new ResponseEntity<>(certificateSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Certificate> update(@RequestBody Certificate certificate) {
        if (certificate.getIdCertificate() != null && this.certificateService.exists(certificate.getIdCertificate())) {
            return this.certificateService.save(certificate)
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
