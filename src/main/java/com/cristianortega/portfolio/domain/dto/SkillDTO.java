package com.cristianortega.portfolio.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
