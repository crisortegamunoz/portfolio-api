package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    Optional<List<Skill>> findAllByCategory_Name(String CategoryName);
    Optional<List<Skill>> findAllByCategory_NameOrderByPercentageDesc(String CategoryName);

}
