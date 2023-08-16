package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.CategoryDTO;
import com.cristianortega.portfolio.domain.mapper.CategoryMapper;
import com.cristianortega.portfolio.domain.mapper.CertificateMapper;
import com.cristianortega.portfolio.domain.util.PageConvert;
import com.cristianortega.portfolio.persistence.entity.Category;
import com.cristianortega.portfolio.persistence.entity.Certificate;
import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
import com.cristianortega.portfolio.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Optional<Page<CategoryDTO>> getAll(Pageable pageRequest) {
        Optional<Page<Category>> pageOptional = Optional.ofNullable(this.categoryService.getAll(pageRequest));
        return pageOptional.map(page -> PageConvert.convertPage(page, CategoryMapper.INSTANCE.toCategoriesDTO(page.getContent())));
    }
    public Optional<CategoryDTO> save(CategoryDTO technologyDTO) {
        return this.categoryService.save(CategoryMapper.INSTANCE.toCategory(technologyDTO))
                .map(CategoryMapper.INSTANCE::toCategoryDTO);
    }
    public Optional<CategoryDTO> getById(int id) {
        return this.categoryService.getById(id).map(CategoryMapper.INSTANCE::toCategoryDTO);
    }

    public Optional<List<CategoryDTO>> getBySection(Section section) {
        List<CategoryDTO> array = new ArrayList<>(0);
        this.categoryService.getBySection(section).ifPresent(skills -> {
            array.addAll(CategoryMapper.INSTANCE.toCategoriesDTO(skills));
        });
        return Optional.of(array);
    }
}
