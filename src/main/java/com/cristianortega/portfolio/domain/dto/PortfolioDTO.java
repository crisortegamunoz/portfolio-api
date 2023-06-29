package com.cristianortega.portfolio.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PortfolioDTO {

    private Integer id;
    private String portfolioName;
    private String clientName;
    private String img;
    private String[] descriptions;
    private String repository;
    private String demo;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime publishDate;
    private List<TechnologyDTO> technologies;
    private CategoryDTO category;
}
