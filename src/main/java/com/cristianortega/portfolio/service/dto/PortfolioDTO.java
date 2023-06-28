package com.cristianortega.portfolio.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PortfolioDTO {

    private Integer id;
    private String portfolioName;
    private String clientName;
    private String img;
    @JsonIgnore
    private String description;
    private String[] descriptions;
    private String repository;
    private String demo;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime publishDate;
    private Integer categoryId;
    private String categoryName;
}
