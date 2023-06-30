package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.TechnologyDTO;
import com.cristianortega.portfolio.domain.mapper.TechnologyMapper;
import com.cristianortega.portfolio.service.TechnologyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TechnologyDTOService {
    private final TechnologyService technologyService;

    public TechnologyDTOService(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }
    public Optional<List<TechnologyDTO>> getAll() {
        List<TechnologyDTO> array = new ArrayList<>(0);
        this.technologyService.getAll().ifPresent(skills -> {
            array.addAll(TechnologyMapper.INSTANCE.toTechnologiesDTO(skills));
        });
        return Optional.of(array);
    }
    public Optional<TechnologyDTO> save(TechnologyDTO technologyDTO) {
        return this.technologyService.save(TechnologyMapper.INSTANCE.toTechnology(technologyDTO))
                .map(TechnologyMapper.INSTANCE::toTechnologyDto);
    }
    public Optional<TechnologyDTO> getById(int id) {
        return this.technologyService.getById(id).map(TechnologyMapper.INSTANCE::toTechnologyDto);
    }

}
