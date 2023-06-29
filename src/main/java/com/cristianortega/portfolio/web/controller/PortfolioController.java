package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.dto.PortfolioDTO;
import com.cristianortega.portfolio.domain.service.PortfolioDTOService;
import com.cristianortega.portfolio.persistence.entity.Portfolio;
import com.cristianortega.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
public class PortfolioController {

    private final PortfolioService portfolioService;
    private final PortfolioDTOService portfolioDTOService;
    @Autowired
    public PortfolioController(PortfolioService portfolioService,
                               PortfolioDTOService portfolioDTOService) {
        this.portfolioService = portfolioService;
        this.portfolioDTOService = portfolioDTOService;
    }

    @GetMapping
    public ResponseEntity<List<PortfolioDTO>> getAll() {
        return this.portfolioDTOService.getAll()
                .map(portfolios -> new ResponseEntity<>(portfolios, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PortfolioDTO> save(@RequestBody PortfolioDTO portfolioDTO) {
        if (portfolioDTO.getId() == null || !this.portfolioService.exists(portfolioDTO.getId())) {
            return this.portfolioDTOService.save(portfolioDTO)
                    .map(portfolioSaved -> new ResponseEntity<>(portfolioSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PortfolioDTO> update(@RequestBody PortfolioDTO portfolioDTO) {
        if (portfolioDTO.getId() != null && this.portfolioService.exists(portfolioDTO.getId())) {
            return this.portfolioDTOService.save(portfolioDTO)
                    .map(portfolioSaved -> new ResponseEntity<>(portfolioSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.portfolioService.exists(id)) {
            this.portfolioService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
