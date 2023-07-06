package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.Category;
import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Optional<List<Category>> findBySectionOrderByIdCategoryDesc(Section section);

}
