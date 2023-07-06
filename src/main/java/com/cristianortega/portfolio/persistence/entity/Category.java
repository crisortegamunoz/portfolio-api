package com.cristianortega.portfolio.persistence.entity;

import com.cristianortega.portfolio.persistence.entity.enumeration.Section;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", nullable = false)
    private Integer idCategory;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private Section section;

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Certificate> certificates;

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Portfolio> portfolios;

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Experience> experiences;

    @OneToMany(mappedBy="category", fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Skill> skills;

}
