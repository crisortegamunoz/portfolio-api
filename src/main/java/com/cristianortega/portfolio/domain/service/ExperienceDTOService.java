package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.ExperienceDTO;
import com.cristianortega.portfolio.domain.mapper.ExperienceMapper;
import com.cristianortega.portfolio.service.ExperienceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExperienceDTOService {

    private final ExperienceService experienceService;
    public ExperienceDTOService(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    public Optional<List<ExperienceDTO>> getAll() {
        List<ExperienceDTO> array = new ArrayList<>(0);
        this.experienceService.getAll().ifPresent(portfolios -> {
            array.addAll(ExperienceMapper.INSTANCE.toExperiencesDTO(portfolios));
        });
        return Optional.of(array);
    }

    public Optional<ExperienceDTO> save(ExperienceDTO experienceDTO) {
        return this.experienceService.save(ExperienceMapper.INSTANCE.toExperience(experienceDTO))
                .map(ExperienceMapper.INSTANCE::toExperienceDTO);
    }

    public Optional<ExperienceDTO> getById(int id) {
        return this.experienceService.getById(id).map(ExperienceMapper.INSTANCE::toExperienceDTO);
    }
}
