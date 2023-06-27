package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.persistence.entity.Knowlegde;
import com.cristianortega.portfolio.persistence.entity.Skill;
import com.cristianortega.portfolio.service.KnowlegdeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/knowlegdes")
public class KnowlegdeController {

    private final KnowlegdeService knowlegdeService;
    @Autowired
    public KnowlegdeController(KnowlegdeService knowlegdeService) {
        this.knowlegdeService = knowlegdeService;
    }

    @GetMapping
    public ResponseEntity<List<Knowlegde>> getAll() {
        return this.knowlegdeService.getAll()
                .map(knowlegdes -> new ResponseEntity<>(knowlegdes, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Knowlegde> save(@RequestBody Knowlegde knowlegde) {
        if (knowlegde.getIdKnowlegde() == null || !this.knowlegdeService.exists(knowlegde.getIdKnowlegde())) {
            return this.knowlegdeService.save(knowlegde)
                    .map(knowlegdeSaved -> new ResponseEntity<>(knowlegdeSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Knowlegde> update(@RequestBody Knowlegde knowlegde) {
        if (knowlegde.getIdKnowlegde() != null && this.knowlegdeService.exists(knowlegde.getIdKnowlegde())) {
            return this.knowlegdeService.save(knowlegde)
                    .map(knowlegdeSaved -> new ResponseEntity<>(knowlegdeSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.knowlegdeService.exists(id)) {
            this.knowlegdeService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
