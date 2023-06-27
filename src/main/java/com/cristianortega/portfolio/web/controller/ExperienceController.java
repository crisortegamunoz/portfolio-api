package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;
    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

}
