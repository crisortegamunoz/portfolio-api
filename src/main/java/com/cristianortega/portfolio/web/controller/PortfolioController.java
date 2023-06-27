package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.persistence.entity.Knowlegde;
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
    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public ResponseEntity<List<Portfolio>> getAll() {
        return this.portfolioService.getAll()
                .map(portfolios -> new ResponseEntity<>(portfolios, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Portfolio> save(@RequestBody Portfolio portfolio) {
        if (portfolio.getIdPortfolio() == null || !this.portfolioService.exists(portfolio.getIdPortfolio())) {
            return this.portfolioService.save(portfolio)
                    .map(portfolioSaved -> new ResponseEntity<>(portfolioSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Portfolio> update(@RequestBody Portfolio portfolio) {
        if (portfolio.getIdPortfolio() != null && this.portfolioService.exists(portfolio.getIdPortfolio())) {
            return this.portfolioService.save(portfolio)
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
