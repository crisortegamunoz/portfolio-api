package com.cristianortega.portfolio.domain.service;

import com.cristianortega.portfolio.domain.dto.AboutDTO;
import com.cristianortega.portfolio.domain.mapper.AboutMapper;
import com.cristianortega.portfolio.persistence.entity.About;
import com.cristianortega.portfolio.persistence.entity.AboutBox;
import com.cristianortega.portfolio.service.AboutBoxService;
import com.cristianortega.portfolio.service.AboutService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AboutDTOService {

    private final AboutService aboutService;
    private final AboutBoxService aboutBoxService;

    public AboutDTOService(AboutService aboutService,
                           AboutBoxService aboutBoxService) {
        this.aboutService = aboutService;
        this.aboutBoxService = aboutBoxService;
    }
    public Optional<List<AboutDTO>> getAll() {
        List<AboutDTO> array = new ArrayList<>(0);
        this.aboutService.getAll().ifPresent(abouts -> {
            array.addAll(AboutMapper.INSTANCE.toAboutsDTO(abouts));
        });
        return Optional.of(array);
    }

    public Optional<AboutDTO> getById(int id) {
        return this.aboutService.getById(id).map(AboutMapper.INSTANCE::toAboutDTO);
    }

    @Transactional
    public Optional<AboutDTO> save(AboutDTO aboutDTO) {
        return this.aboutService.save(getAboutWithBoxes(aboutDTO))
                .map(AboutMapper.INSTANCE::toAboutDTO);
    }

    private About getAboutWithBoxes(AboutDTO aboutDTO) {
        About about = AboutMapper.INSTANCE.toAbout(aboutDTO);
        Optional<List<AboutBox>> optionalBoxes = aboutBoxService.saveAll(about.getAboutBoxes());
        optionalBoxes.ifPresent(about::setAboutBoxes);
        return about;
    }


}
