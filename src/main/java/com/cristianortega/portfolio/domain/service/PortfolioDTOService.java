package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.PortfolioDTO;
import com.cristianortega.portfolio.domain.mapper.PortfolioLightMapper;
import com.cristianortega.portfolio.domain.mapper.PortfolioMapper;
import com.cristianortega.portfolio.domain.util.PageConvert;
import com.cristianortega.portfolio.persistence.entity.Portfolio;
import com.cristianortega.portfolio.service.PortfolioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioDTOService {

    private final PortfolioService portfolioService;

    public PortfolioDTOService(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }
    public Optional<Page<PortfolioDTO>> getAll(Pageable pageRequest) {
        Optional<Page<Portfolio>> pageOptional = Optional.ofNullable(this.portfolioService.getAll(pageRequest));
        return pageOptional.map(page -> PageConvert.convertPage(page, PortfolioLightMapper.INSTANCE.toPortfoliosDTOLight(page.getContent())));
    }
    public Optional<PortfolioDTO> save(PortfolioDTO portfolioDTO) {
        return this.portfolioService.save(PortfolioMapper.INSTANCE.toPortfolio(portfolioDTO))
                .map(PortfolioMapper.INSTANCE::toPortfolioDTO);
    }
    public Optional<PortfolioDTO> getById(int id) {
        return this.portfolioService.getById(id).map(PortfolioMapper.INSTANCE::toPortfolioDTO);
    }
    public Optional<Page<PortfolioDTO>> getByCategory(Pageable pageRequest, int idCategory) {
        Optional<Page<Portfolio>> pageOptional = Optional.ofNullable(this.portfolioService.getByCategory(pageRequest, idCategory));
        return pageOptional.map(page -> PageConvert.convertPage(page, PortfolioLightMapper.INSTANCE.toPortfoliosDTOLight(page.getContent())));
    }
}
