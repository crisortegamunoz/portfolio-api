package com.cristianortega.portfolio.persistence.repository.pagination;

import com.cristianortega.portfolio.persistence.entity.Certificate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface CertificatePageSortRepository extends ListPagingAndSortingRepository<Certificate, Integer> {
    Page<Certificate> findAllBy(Pageable pageable);
    Page<Certificate> findAllByIdCategory(Pageable pageable, int idCategory);
}
