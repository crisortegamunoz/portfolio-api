package com.cristianortega.portfolio.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class AboutDTO {

    private Integer id;
    @JsonIgnore
    private String description;
    private String[] descriptions;
    private List<BoxDTO> boxes;

}
