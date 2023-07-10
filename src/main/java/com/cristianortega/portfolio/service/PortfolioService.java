package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Portfolio;
import com.cristianortega.portfolio.persistence.repository.PortfolioRepository;
import com.cristianortega.portfolio.persistence.repository.pagination.PortfolioPageSortRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioPageSortRepository portfolioPageSortRepository;

    public PortfolioService(PortfolioRepository portfolioRepository,
                            PortfolioPageSortRepository portfolioPageSortRepository) {
        this.portfolioRepository = portfolioRepository;
        this.portfolioPageSortRepository = portfolioPageSortRepository;
    }

    public Page<Portfolio> getAll(Pageable pageRequest) {
        return this.portfolioPageSortRepository.findAllBy(pageRequest);
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

    public Optional<Portfolio> getById(Integer id) {
        return portfolioRepository.findById(id);
    }

    public void delete(Integer id) {
        this.portfolioRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.portfolioRepository.existsById(id);
    }

}
