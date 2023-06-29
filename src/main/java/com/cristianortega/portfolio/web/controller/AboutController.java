package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.dto.AboutDTO;
import com.cristianortega.portfolio.domain.service.AboutDTOService;
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
    private final AboutDTOService aboutDTOService;
    @Autowired
    public AboutController(AboutService aboutService,
                           AboutDTOService aboutDTOService) {
        this.aboutService = aboutService;
        this.aboutDTOService = aboutDTOService;
    }

    @GetMapping
    public ResponseEntity<List<AboutDTO>> getAll() {
        return this.aboutDTOService.getAll()
                .map(abouts -> new ResponseEntity<>(abouts, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AboutDTO> save(@RequestBody AboutDTO aboutDTO) {
        if (aboutDTO.getId() == null || !this.aboutService.exists(aboutDTO.getId())) {
            return this.aboutDTOService.save(aboutDTO)
                    .map(aboutSaved -> new ResponseEntity<>(aboutSaved, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<AboutDTO> update(@RequestBody AboutDTO aboutDTO) {
        if (aboutDTO.getId() != null && this.aboutService.exists(aboutDTO.getId())) {
            return this.aboutDTOService.save(aboutDTO)
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
    @GetMapping("/{id}")
    public ResponseEntity<AboutDTO> getById(@PathVariable int id) {
        return this.aboutDTOService.getById(id)
                .map(aboutDTO -> new ResponseEntity<>(aboutDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
