package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.dto.ExperienceDTO;
import com.cristianortega.portfolio.domain.service.ExperienceDTOService;
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
    private final ExperienceDTOService experienceDTOService;
    @Autowired
    public ExperienceController(ExperienceService experienceService,
                                ExperienceDTOService experienceDTOService) {
        this.experienceService = experienceService;
        this.experienceDTOService = experienceDTOService;
    }

    @GetMapping
    public ResponseEntity<List<ExperienceDTO>> getAll() {
        return this.experienceDTOService.getAll()
                .map(experiences -> new ResponseEntity<>(experiences, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ExperienceDTO> save(@RequestBody ExperienceDTO experienceDTO) {
        if (experienceDTO.getId() == null || !this.experienceService.exists(experienceDTO.getId())) {
            return this.experienceDTOService.save(experienceDTO)
                    .map(experienceSaved -> new ResponseEntity<>(experienceSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<ExperienceDTO> update(@RequestBody ExperienceDTO experienceDTO) {
        if (experienceDTO.getId() != null && this.experienceService.exists(experienceDTO.getId())) {
            return this.experienceDTOService.save(experienceDTO)
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
