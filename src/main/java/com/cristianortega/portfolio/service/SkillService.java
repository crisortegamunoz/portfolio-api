package com.cristianortega.portfolio.service;

import com.cristianortega.portfolio.persistence.entity.Skill;
import com.cristianortega.portfolio.persistence.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Optional<List<Skill>> getAll() {
        return Optional.of(skillRepository.findAll());
    }

    public Optional<Skill> save(Skill skill) {
        return Optional.of(skillRepository.save(skill));
    }

    public Optional<Skill> update(Skill skill) {
        if (exists(skill.getIdSkill())) {
            return Optional.of(skillRepository.save(skill));
        } else {
            return Optional.empty();
        }
    }

    public Optional<Skill> findById(Integer id) {
        return skillRepository.findById(id);
    }

    public void delete(Integer id) {
        this.skillRepository.deleteById(id);
    }

    public boolean exists(Integer id) {
        return this.skillRepository.existsById(id);
    }

}
