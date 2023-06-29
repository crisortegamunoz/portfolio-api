package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.About;
import com.cristianortega.portfolio.persistence.repository.AboutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutService {

    private final AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    public Optional<List<About>> getAll() {
        return Optional.of(aboutRepository.findAll());
    }

    public Optional<About> save(About about) {
        return Optional.of(aboutRepository.save(about));
    }

    public Optional<About> update(About about) {
        if (exists(about.getIdAbout())) {
            return Optional.of(aboutRepository.save(about));
        } else {
            return Optional.empty();
        }
    }

    public Optional<About> getById(Integer id) {
        return aboutRepository.findById(id);
    }

    public void delete(Integer id) {
        this.aboutRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.aboutRepository.existsById(id);
    }


}
