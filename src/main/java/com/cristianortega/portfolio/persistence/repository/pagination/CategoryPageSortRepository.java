package com.cristianortega.portfolio.persistence.repository.pagination;

import com.cristianortega.portfolio.persistence.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface CategoryPageSortRepository extends ListPagingAndSortingRepository<Category, Integer> {
    Page<Category> findAllBy(Pageable pageable);
}
