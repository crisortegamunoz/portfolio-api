package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.persistence.entity.About;
import com.cristianortega.portfolio.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abouts")
public class AboutController {

    private final AboutService aboutService;
    @Autowired
    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping
    public ResponseEntity<List<About>> getAll() {
        return this.aboutService.getAll()
                .map(abouts -> new ResponseEntity<>(abouts, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<About> save(@RequestBody About about) {
        if (about.getIdAbout() == null || !this.aboutService.exists(about.getIdAbout())) {
            return this.aboutService.save(about)
                    .map(aboutSaved -> new ResponseEntity<>(aboutSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<About> update(@RequestBody About about) {
        if (about.getIdAbout() != null && this.aboutService.exists(about.getIdAbout())) {
            return this.aboutService.save(about)
                    .map(aboutSaved -> new ResponseEntity<>(aboutSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.aboutService.exists(id)) {
            this.aboutService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
