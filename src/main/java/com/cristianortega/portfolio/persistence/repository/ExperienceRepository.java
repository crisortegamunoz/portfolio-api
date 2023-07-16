package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

    Optional<List<Experience>> findAllByCategory_NameOrderByIdExperienceDesc(String CategoryName);

}
