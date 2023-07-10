package com.cristianortega.portfolio.persistence.repository.pagination;

import com.cristianortega.portfolio.persistence.entity.Portfolio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PortfolioPageSortRepository extends ListPagingAndSortingRepository<Portfolio, Integer> {
    Page<Portfolio> findAllBy(Pageable pageable);
}
