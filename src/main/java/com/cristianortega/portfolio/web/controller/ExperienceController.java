package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.persistence.entity.Experience;
import com.cristianortega.portfolio.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;
    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping
    public ResponseEntity<List<Experience>> getAll() {
        return this.experienceService.getAll()
                .map(experiences -> new ResponseEntity<>(experiences, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Experience> save(@RequestBody Experience experience) {
        if (experience.getIdExperience() == null || !this.experienceService.exists(experience.getIdExperience())) {
            return this.experienceService.save(experience)
                    .map(experienceSaved -> new ResponseEntity<>(experienceSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Experience> update(@RequestBody Experience experience) {
        if (experience.getIdExperience() != null && this.experienceService.exists(experience.getIdExperience())) {
            return this.experienceService.save(experience)
                    .map(experienceSaved -> new ResponseEntity<>(experienceSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.experienceService.exists(id)) {
            this.experienceService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
