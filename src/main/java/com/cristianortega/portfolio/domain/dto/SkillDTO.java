package com.cristianortega.portfolio.domain.dto;

import lombok.Data;
@Data
public class SkillDTO {

    private Integer id;
    private String name;
    private Boolean show;
    private Integer percentage;
    private String cssClass;
    private String cssStyle;
    private TechnologyDTO technology;
    private CategoryDTO category;

}
