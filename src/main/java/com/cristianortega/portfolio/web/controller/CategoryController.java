package com.cristianortega.portfolio.web.controller;

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
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return this.categoryService.getAll()
                .map(categories -> new ResponseEntity<>(categories, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        return this.categoryService.findById(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        if (category.getIdCategory() == null || !this.categoryService.exists(category.getIdCategory())) {
            return this.categoryService.save(category)
                    .map(categorySaved -> new ResponseEntity<>(categorySaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Category> update(@RequestBody Category category) {
        if (category.getIdCategory() != null && this.categoryService.exists(category.getIdCategory())) {
            return this.categoryService.save(category)
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
