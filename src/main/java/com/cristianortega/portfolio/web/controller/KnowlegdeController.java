package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.service.KnowlegdeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/knowlegdes")
public class KnowlegdeController {

    private final KnowlegdeService knowlegdeService;
    @Autowired
    public KnowlegdeController(KnowlegdeService knowlegdeService) {
        this.knowlegdeService = knowlegdeService;
    }

}
