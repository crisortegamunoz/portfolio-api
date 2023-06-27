package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
}
