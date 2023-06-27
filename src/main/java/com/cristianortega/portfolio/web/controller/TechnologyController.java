package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;
    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

}
