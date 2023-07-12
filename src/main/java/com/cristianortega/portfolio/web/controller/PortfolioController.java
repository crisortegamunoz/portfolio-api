package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.dto.PortfolioDTO;
import com.cristianortega.portfolio.domain.service.PortfolioDTOService;
import com.cristianortega.portfolio.service.PortfolioService;
import com.cristianortega.portfolio.web.util.PageableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<PortfolioDTO>> getAll(@RequestParam(defaultValue = "0") int pages,
                                                     @RequestParam(defaultValue = "50") int elements,
                                                     @RequestParam(defaultValue = "idPortfolio") String sortBy,
                                                     @RequestParam(defaultValue = "DESC") String sortDirection) {
        return this.portfolioDTOService.getAll(PageableUtil.basicPageable(pages, elements, sortBy, sortDirection))
                .map(page -> new ResponseEntity<>(page, HttpStatus.OK))
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
    @GetMapping("/{id}")
    public ResponseEntity<PortfolioDTO> getById(@PathVariable int id) {
        return this.portfolioDTOService.getById(id)
                .map(portfolioDTO -> new ResponseEntity<>(portfolioDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Page<PortfolioDTO>> getByCategory(@PathVariable int id,
                                                     @RequestParam(defaultValue = "0") int pages,
                                                     @RequestParam(defaultValue = "50") int elements,
                                                     @RequestParam(defaultValue = "idPortfolio") String sortBy,
                                                     @RequestParam(defaultValue = "DESC") String sortDirection) {
        return this.portfolioDTOService.getByCategory(PageableUtil.basicPageable(pages, elements, sortBy, sortDirection), id)
                .map(page -> new ResponseEntity<>(page, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
