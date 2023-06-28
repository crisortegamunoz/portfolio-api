package com.cristianortega.portfolio.service.dto;

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
    private Integer categoryId;
    private String categoryName;

}
