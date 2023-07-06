package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Category;
import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
import com.cristianortega.portfolio.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<List<Category>> getAll() {
        return Optional.of(categoryRepository.findAll());
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
