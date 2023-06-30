package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.SkillDTO;
import com.cristianortega.portfolio.domain.mapper.SkillMapper;
import com.cristianortega.portfolio.persistence.entity.Skill;
import com.cristianortega.portfolio.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SkillDTOService {

    private final SkillService skillService;

    public SkillDTOService(SkillService skillService) {
        this.skillService = skillService;
    }

    public Optional<List<SkillDTO>> getAll() {
        List<SkillDTO> array = new ArrayList<>(0);
        this.skillService.getAll().ifPresent(skills -> {
            array.addAll(SkillMapper.INSTANCE.toSkillsDTO(skills));
        });
        return Optional.of(array);
    }

    public Optional<SkillDTO> save(SkillDTO skillDTO) {
        return this.skillService.save(SkillMapper.INSTANCE.toSkill(skillDTO))
                .map(SkillMapper.INSTANCE::toSkillDTO);
    }

    public Optional<SkillDTO> getById(int id) {
        return this.skillService.getById(id).map(SkillMapper.INSTANCE::toSkillDTO);
    }
}
