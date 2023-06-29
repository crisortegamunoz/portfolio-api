package com.cristianortega.portfolio.domain.mapper;

import com.cristianortega.portfolio.domain.dto.AboutDTO;
import com.cristianortega.portfolio.persistence.entity.About;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { AboutBoxMapper.class })
public interface AboutMapper {

    AboutMapper INSTANCE = Mappers.getMapper(AboutMapper.class);
    @Mappings({
            @Mapping(source = "idAbout", target = "id"),
            @Mapping(source = "aboutBoxes", target = "boxes")
    })
    AboutDTO toAboutDTO(About about);
    List<AboutDTO> toAboutsDTO(List<About> experiences);
    @InheritInverseConfiguration
    About toAbout(AboutDTO experienceDTO);

}
