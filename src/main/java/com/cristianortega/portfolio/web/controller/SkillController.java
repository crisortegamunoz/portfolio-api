package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;
    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

}
