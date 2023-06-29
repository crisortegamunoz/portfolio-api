package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.persistence.entity.Technology;
import com.cristianortega.portfolio.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;
    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public ResponseEntity<List<Technology>> getAll() {
        return this.technologyService.getAll()
                .map(technologies -> new ResponseEntity<>(technologies, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Technology> save(@RequestBody Technology technology) {
        if (technology.getIdTechnology() == null || !this.technologyService.exists(technology.getIdTechnology())) {
            return this.technologyService.save(technology)
                    .map(technologySaved -> new ResponseEntity<>(technologySaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Technology> update(@RequestBody Technology technology) {
        if (technology.getIdTechnology() != null && this.technologyService.exists(technology.getIdTechnology())) {
            return this.technologyService.save(technology)
                    .map(technologySaved -> new ResponseEntity<>(technologySaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (this.technologyService.exists(id)) {
            this.technologyService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technology> getById(@PathVariable int id) {
        return this.technologyService.getById(id)
                .map(technology -> new ResponseEntity<>(technology, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
