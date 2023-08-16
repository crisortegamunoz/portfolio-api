package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Category;
import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
import com.cristianortega.portfolio.persistence.repository.CategoryRepository;
import com.cristianortega.portfolio.persistence.repository.pagination.CategoryPageSortRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryPageSortRepository categoryPageSortRepository;
    public CategoryService(CategoryRepository categoryRepository, CategoryPageSortRepository categoryPageSortRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryPageSortRepository = categoryPageSortRepository;
    }

    public Page<Category> getAll(Pageable pageRequest) {
        return this.categoryPageSortRepository.findAll(pageRequest);
    }

    public Optional<Category> save(Category category) {
        return Optional.of(categoryRepository.save(category));
    }

    public Optional<Category> update(Category category) {
        if (exists(category.getIdCategory())) {
            return Optional.of(categoryRepository.save(category));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Category> getById(Integer id) {
        return categoryRepository.findById(id);
    }

    public void delete(Integer id) {
        this.categoryRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.categoryRepository.existsById(id);
    }

    public Optional<List<Category>> getBySection(Section section) {
        return this.categoryRepository.findBySectionOrderByIdCategoryDesc(section);
    }
}
