package com.cristianortega.portfolio.service.dto;

import lombok.Data;

@Data
public class BoxDTO {

    private Integer id;
    private String title;
    private String description;
    private String cssStyle;
    private String iconImg;
    private Integer order;

}
