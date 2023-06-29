package com.cristianortega.portfolio.domain.mapper;

import com.cristianortega.portfolio.domain.dto.SkillDTO;
import com.cristianortega.portfolio.persistence.entity.Skill;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { CategoryMapper.class, TechnologyMapper.class })
public interface SkillMapper {

    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);

    @Mappings({
            @Mapping(source = "idSkill", target = "id"),
            @Mapping(source = "available", target = "show"),
            @Mapping(source = "css", target = "cssClass"),
            @Mapping(source = "style", target = "cssStyle")
    })
    SkillDTO toSkillDTO(Skill skill);
    List<SkillDTO> toSkillsDTO(List<Skill> skills);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "category.id", target = "idCategory"),
            @Mapping(source = "technology.id", target = "idTechnology")
    })
    Skill toSkill(SkillDTO certificateDTO);

}
