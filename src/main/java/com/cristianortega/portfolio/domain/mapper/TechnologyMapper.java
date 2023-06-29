package com.cristianortega.portfolio.domain.mapper;

import com.cristianortega.portfolio.domain.dto.TechnologyDTO;
import com.cristianortega.portfolio.persistence.entity.Technology;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TechnologyMapper {

    TechnologyMapper INSTANCE = Mappers.getMapper(TechnologyMapper.class);

    @Mapping(source = "idTechnology", target = "id")
    TechnologyDTO toTechnologyDto(Technology technology);

    List<TechnologyDTO> toTechnologiesDTO(List<Technology> technologies);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "skills", ignore = true),
            @Mapping(target = "portfolios", ignore = true),
            @Mapping(target = "experiences", ignore = true)
    })
    Technology toTechnology(TechnologyDTO technologyDTO);

}
