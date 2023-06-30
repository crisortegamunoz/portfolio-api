package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.dto.CategoryDTO;
import com.cristianortega.portfolio.domain.service.CategoryDTOService;
import com.cristianortega.portfolio.persistence.entity.Category;
import com.cristianortega.portfolio.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryDTOService categoryDTOService;
    @Autowired
    public CategoryController(CategoryService categoryService,
                              CategoryDTOService categoryDTOService) {
        this.categoryService = categoryService;
        this.categoryDTOService = categoryDTOService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return this.categoryDTOService.getAll()
                .map(categories -> new ResponseEntity<>(categories, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id) {
        return this.categoryDTOService.getById(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO) {
        if (categoryDTO.getId() == null || !this.categoryService.exists(categoryDTO.getId())) {
            return this.categoryDTOService.save(categoryDTO)
                    .map(categorySaved -> new ResponseEntity<>(categorySaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO) {
        if (categoryDTO.getId() != null && this.categoryService.exists(categoryDTO.getId())) {
            return this.categoryDTOService.save(categoryDTO)
                    .map(categorySaved -> new ResponseEntity<>(categorySaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.categoryService.exists(id)) {
            this.categoryService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
