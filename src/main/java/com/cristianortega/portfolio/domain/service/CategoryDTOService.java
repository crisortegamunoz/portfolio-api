package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.CategoryDTO;
import com.cristianortega.portfolio.domain.mapper.CategoryMapper;
import com.cristianortega.portfolio.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryDTOService {

    public final CategoryService categoryService;
    public CategoryDTOService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Optional<List<CategoryDTO>> getAll() {
        List<CategoryDTO> array = new ArrayList<>(0);
        this.categoryService.getAll().ifPresent(skills -> {
            array.addAll(CategoryMapper.INSTANCE.toCategoriesDTO(skills));
        });
        return Optional.of(array);
    }
    public Optional<CategoryDTO> save(CategoryDTO technologyDTO) {
        return this.categoryService.save(CategoryMapper.INSTANCE.toCategory(technologyDTO))
                .map(CategoryMapper.INSTANCE::toCategoryDTO);
    }
    public Optional<CategoryDTO> getById(int id) {
        return this.categoryService.getById(id).map(CategoryMapper.INSTANCE::toCategoryDTO);
    }
}
