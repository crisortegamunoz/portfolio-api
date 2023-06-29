package com.cristianortega.portfolio.domain.mapper;

import com.cristianortega.portfolio.domain.dto.BoxDTO;
import com.cristianortega.portfolio.persistence.entity.AboutBox;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AboutBoxMapper {

    AboutBoxMapper INSTANCE = Mappers.getMapper(AboutBoxMapper.class);
    @Mappings({
            @Mapping(source = "idAboutBox", target = "id"),
            @Mapping(source = "css", target = "cssStyle"),
            @Mapping(source = "image", target = "iconImg"),
            @Mapping(source = "orderDisplay", target = "order")
    })
    BoxDTO toBoxDTO(AboutBox aboutBox);
    List<BoxDTO> toBoxesDTO(List<AboutBox> boxes);
    @InheritInverseConfiguration
    AboutBox toAboutBox(BoxDTO boxDTO);

}
