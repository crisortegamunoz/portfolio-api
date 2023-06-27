package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.repository.SkillRepository;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

}
