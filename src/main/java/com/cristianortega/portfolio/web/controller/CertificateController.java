package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.service.CertificateDTOService;
import com.cristianortega.portfolio.service.CertificateService;
import com.cristianortega.portfolio.domain.dto.CertificateDTO;
import com.cristianortega.portfolio.web.util.PageableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<CertificateDTO>> getAll(@RequestParam(defaultValue = "0") int pages,
                                                       @RequestParam(defaultValue = "50") int elements,
                                                       @RequestParam(defaultValue = "idCertificate") String sortBy,
                                                       @RequestParam(defaultValue = "DESC") String sortDirection) {
        return this.certificateDTOService.getAll(PageableUtil.basicPageable(pages, elements, sortBy, sortDirection))
                .map(page -> new ResponseEntity<>(page, HttpStatus.OK))
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
    @GetMapping("/{id}")
    public ResponseEntity<CertificateDTO> getById(@PathVariable int id) {
        return this.certificateDTOService.getById(id)
                .map(certificateDTO -> new ResponseEntity<>(certificateDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Page<CertificateDTO>> getByCategory(@PathVariable int id,
                                                            @RequestParam(defaultValue = "0") int pages,
                                                            @RequestParam(defaultValue = "50") int elements,
                                                            @RequestParam(defaultValue = "idCertificate") String sortBy,
                                                            @RequestParam(defaultValue = "DESC") String sortDirection) {
        return this.certificateDTOService.getByCategory(PageableUtil.basicPageable(pages, elements, sortBy, sortDirection), id)
                .map(page -> new ResponseEntity<>(page, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
