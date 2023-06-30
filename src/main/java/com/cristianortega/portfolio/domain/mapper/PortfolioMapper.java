package com.cristianortega.portfolio.domain.mapper;

import com.cristianortega.portfolio.domain.dto.PortfolioDTO;
import com.cristianortega.portfolio.persistence.entity.Portfolio;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { CategoryMapper.class, TechnologyMapper.class })
public interface PortfolioMapper {

    PortfolioMapper INSTANCE = Mappers.getMapper(PortfolioMapper.class);
    @Mappings({
            @Mapping(source = "idPortfolio", target = "id"),
            @Mapping(source = "name", target = "portfolioName"),
            @Mapping(source = "image", target = "img"),
            @Mapping(source = "description", target = "descriptions"),
            @Mapping(source = "repositoryUrl", target = "repository"),
            @Mapping(source = "demoUrl", target = "demo"),
            @Mapping(source = "workingFrom", target = "startDate"),
            @Mapping(source = "workingTo", target = "endDate"),
            @Mapping(source = "publishDate", target = "publishDate"),
            @Mapping(source = "portfolioTechnologies", target = "technologies")
    })
    PortfolioDTO toPortfolioDTO(Portfolio portfolio);
    List<PortfolioDTO> toPortfoliosDTO(List<Portfolio> portfolios);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "category.id", target = "idCategory")
    })
    Portfolio toPortfolio(PortfolioDTO portfolioDTO);

}
