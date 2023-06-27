package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abouts")
public class AboutController {

    private final AboutService aboutService;
    @Autowired
    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }
}
