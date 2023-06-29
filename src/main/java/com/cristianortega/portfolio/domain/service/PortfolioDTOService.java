package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.PortfolioDTO;
import com.cristianortega.portfolio.domain.mapper.PortfolioMapper;
import com.cristianortega.portfolio.service.PortfolioService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioDTOService {

    private final PortfolioService portfolioService;

    public PortfolioDTOService(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    public Optional<List<PortfolioDTO>> getAll() {
        List<PortfolioDTO> array = new ArrayList<>(0);
        this.portfolioService.getAll().ifPresent(portfolios -> {
            array.addAll(PortfolioMapper.INSTANCE.toPortfoliosDTO(portfolios));
        });
        return Optional.of(array);
    }

    public Optional<PortfolioDTO> save(PortfolioDTO portfolioDTO) {
        return this.portfolioService.save(PortfolioMapper.INSTANCE.toPortfolio(portfolioDTO))
                .map(PortfolioMapper.INSTANCE::toPortfolioDTO);
    }
}
