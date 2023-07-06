package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.Certificate;
import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {

    Optional<List<Certificate>> findAllByOrderByIdCertificateDesc();

}
