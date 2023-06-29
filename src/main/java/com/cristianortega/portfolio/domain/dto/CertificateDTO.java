package com.cristianortega.portfolio.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CertificateDTO {

    private Integer id;
    private String name;
    private String pdfUrl;
    private String imgUrl;
    private String entityName;
    private LocalDateTime completed;
    private CategoryDTO category;

}
