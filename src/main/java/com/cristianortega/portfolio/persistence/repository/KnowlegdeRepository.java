package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.Knowlegde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowlegdeRepository extends JpaRepository<Knowlegde, Integer> {
}
