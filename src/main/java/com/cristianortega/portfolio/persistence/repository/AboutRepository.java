package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Integer> {
}
