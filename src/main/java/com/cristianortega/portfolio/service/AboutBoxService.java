package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.AboutBox;
import com.cristianortega.portfolio.persistence.repository.AboutBoxRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AboutBoxService {

    private final AboutBoxRepository aboutBoxRepository;

    public AboutBoxService(AboutBoxRepository aboutBoxRepository) {
        this.aboutBoxRepository = aboutBoxRepository;
    }

    public Optional<AboutBox> save(AboutBox aboutBox) {
        return Optional.of(aboutBoxRepository.save(aboutBox));
    }

    public Optional<List<AboutBox>> saveAll(List<AboutBox> aboutBoxes) {
        final List<AboutBox> boxes = new ArrayList<>(0);
        aboutBoxes.forEach(box -> {
            boxes.add(aboutBoxRepository.save(box));
        });
        return Optional.of(boxes);
    }
    public Optional<AboutBox> update(AboutBox aboutBox) {
        if (exists(aboutBox.getIdAboutBox())) {
            return Optional.of(aboutBoxRepository.save(aboutBox));
        } else {
            return Optional.empty();
        }
    }
    public Optional<AboutBox> getById(Integer id) {
        return aboutBoxRepository.findById(id);
    }
    public void delete(Integer id) {
        this.aboutBoxRepository.deleteById(id);
    }
    public boolean exists(Integer id) {
        return this.aboutBoxRepository.existsById(id);
    }

}
