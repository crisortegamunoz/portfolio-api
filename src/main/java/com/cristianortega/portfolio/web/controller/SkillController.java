package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.persistence.entity.Skill;
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
    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<List<Skill>> getAll() {
        return this.skillService.getAll()
                .map(skills -> new ResponseEntity<>(skills, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Skill> save(@RequestBody Skill skill) {
        if (skill.getIdSkill() == null || !this.skillService.exists(skill.getIdSkill())) {
            return this.skillService.save(skill)
                    .map(skillSaved -> new ResponseEntity<>(skillSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Skill> update(@RequestBody Skill skill) {
        if (skill.getIdSkill() != null && this.skillService.exists(skill.getIdSkill())) {
            return this.skillService.save(skill)
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

}
