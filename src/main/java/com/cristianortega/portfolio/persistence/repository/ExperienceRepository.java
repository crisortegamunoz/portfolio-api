package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
}
