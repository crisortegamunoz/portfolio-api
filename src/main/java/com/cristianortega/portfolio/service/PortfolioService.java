package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Portfolio;
import com.cristianortega.portfolio.persistence.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Optional<List<Portfolio>> getAll() {
        return Optional.of(portfolioRepository.findAll());
    }

    public Optional<Portfolio> save(Portfolio portfolio) {
        return Optional.of(portfolioRepository.save(portfolio));
    }

    public Optional<Portfolio> update(Portfolio portfolio) {
        if (exists(portfolio.getIdPortfolio())) {
            return Optional.of(portfolioRepository.save(portfolio));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Portfolio> findById(Integer id) {
        return portfolioRepository.findById(id);
    }

    public void delete(Integer id) {
        this.portfolioRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.portfolioRepository.existsById(id);
    }

}
