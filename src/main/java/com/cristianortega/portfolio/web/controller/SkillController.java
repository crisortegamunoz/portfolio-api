package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.dto.SkillDTO;
import com.cristianortega.portfolio.domain.service.SkillDTOService;
import com.cristianortega.portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;
    private final SkillDTOService skillDTOService;

    @Autowired
    public SkillController(SkillService skillService,
                           SkillDTOService skillDTOService) {
        this.skillService = skillService;
        this.skillDTOService = skillDTOService;
    }
    @GetMapping
    public ResponseEntity<List<SkillDTO>> getAll() {
        return this.skillDTOService.getAll()
                .map(skills -> new ResponseEntity<>(skills, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<SkillDTO> save(@RequestBody SkillDTO skillDTO) {
        if (skillDTO.getId() == null || !this.skillService.exists(skillDTO.getId())) {
            return this.skillDTOService.save(skillDTO)
                    .map(skillSaved -> new ResponseEntity<>(skillSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping
    public ResponseEntity<SkillDTO> update(@RequestBody SkillDTO skillDTO) {
        if (skillDTO.getId() != null && this.skillService.exists(skillDTO.getId())) {
            return this.skillDTOService.save(skillDTO)
                    .map(skillSaved -> new ResponseEntity<>(skillSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.skillService.exists(id)) {
            this.skillService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<SkillDTO> getById(@PathVariable int id) {
        return this.skillDTOService.getById(id)
                .map(skillDTO -> new ResponseEntity<>(skillDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
