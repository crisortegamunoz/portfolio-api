package com.cristianortega.portfolio.domain.mapper;

import com.cristianortega.portfolio.domain.dto.CategoryDTO;
import com.cristianortega.portfolio.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "idCategory", target = "id")
    CategoryDTO toCategoryDTO(Category category);

    List<CategoryDTO> toCategoriesDTO(List<Category> categories);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "certificates", ignore = true),
            @Mapping(target = "portfolios", ignore = true),
            @Mapping(target = "experiences", ignore = true),
            @Mapping(target = "skills", ignore = true)
    })
    Category toCategory(CategoryDTO categoryDTO);
}
