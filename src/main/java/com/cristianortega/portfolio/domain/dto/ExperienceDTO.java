package com.cristianortega.portfolio.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ExperienceDTO {

    private Integer id;
    private String roleName;
    private String roleDescription;
    private String entityName;
    private String entityDescription;
    private String entityLocation;
    private String[] responsibilities;
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
    private CategoryDTO category;
    private List<TechnologyDTO> technologies;

}
