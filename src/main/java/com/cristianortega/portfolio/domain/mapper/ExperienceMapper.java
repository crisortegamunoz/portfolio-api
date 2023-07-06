package com.cristianortega.portfolio.domain.mapper;

import com.cristianortega.portfolio.domain.dto.ExperienceDTO;
import com.cristianortega.portfolio.persistence.entity.Experience;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { CategoryMapper.class, TechnologyMapper.class })
public interface ExperienceMapper {

    ExperienceMapper INSTANCE = Mappers.getMapper(ExperienceMapper.class);
    @Mappings({
            @Mapping(source = "idExperience", target = "id"),
            @Mapping(source = "role", target = "roleName"),
            @Mapping(source = "entity", target = "entityName"),
            @Mapping(source = "location", target = "entityLocation"),
            @Mapping(source = "startDate", target = "periodStart"),
            @Mapping(source = "endDate", target = "periodEnd"),
            @Mapping(source = "experienceTechnologies", target = "technologies")
    })
    ExperienceDTO toExperienceDTO(Experience experience);
    List<ExperienceDTO> toExperiencesDTO(List<Experience> experiences);
    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "category.id", target = "idCategory")
    })
    Experience toExperience(ExperienceDTO experienceDTO);
}
