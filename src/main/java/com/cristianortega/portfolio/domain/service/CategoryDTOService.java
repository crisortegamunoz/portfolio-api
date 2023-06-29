package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.CategoryDTO;
import com.cristianortega.portfolio.domain.mapper.CategoryMapper;
import com.cristianortega.portfolio.persistence.entity.Category;
import com.cristianortega.portfolio.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryDTOService {
    private final CategoryService categoryService;
    public CategoryDTOService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Optional<List<CategoryDTO>> getAll() {
        Optional<List<Category>> categoryList = this.categoryService.getAll();
        List<CategoryDTO> array = new ArrayList<>(0);
        categoryList.ifPresent(categories -> {
            array.addAll(CategoryMapper.INSTANCE.categoriesToCategoriesDTO(categories));
        });
        return Optional.of(array);
    }

}
