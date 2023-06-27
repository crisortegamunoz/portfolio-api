package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
