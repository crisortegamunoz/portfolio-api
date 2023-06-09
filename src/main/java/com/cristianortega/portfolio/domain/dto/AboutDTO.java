package com.cristianortega.portfolio.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class AboutDTO {

    private Integer id;
    private String title;
    private String[] descriptions;
    private List<BoxDTO> boxes;

}
