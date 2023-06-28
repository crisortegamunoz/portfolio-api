package com.cristianortega.portfolio.service.dto;

import lombok.Data;
@Data
public class SkillDTO {

    private Integer id;
    private String name;
    private Boolean available;
    private Integer percentage;
    private String cssClass;
    private String cssStyle;
    private Integer technologyId;
    private Integer categoryId;

}
