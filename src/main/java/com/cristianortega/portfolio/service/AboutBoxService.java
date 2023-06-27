package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.AboutBox;
import com.cristianortega.portfolio.persistence.repository.AboutBoxRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutBoxService {

    private final AboutBoxRepository aboutBoxRepository;

    public AboutBoxService(AboutBoxRepository aboutBoxRepository) {
        this.aboutBoxRepository = aboutBoxRepository;
    }

    public Optional<AboutBox> save(AboutBox aboutBox) {
        return Optional.of(aboutBoxRepository.save(aboutBox));
    }

    public Optional<AboutBox> update(AboutBox aboutBox) {
        if (exists(aboutBox.getIdAboutBox())) {
            return Optional.of(aboutBoxRepository.save(aboutBox));
        } else {
            return Optional.empty();
        }
    }

    public Optional<AboutBox> findById(Integer id) {
        return aboutBoxRepository.findById(id);
    }

    public void delete(Integer id) {
        this.aboutBoxRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.aboutBoxRepository.existsById(id);
    }

}
