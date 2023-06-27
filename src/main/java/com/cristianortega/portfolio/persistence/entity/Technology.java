package com.cristianortega.portfolio.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "technology")
@Getter
@Setter
@NoArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_technology", nullable = false)
    private Integer idTechnology;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 20)
    private String version;

    @OneToMany(mappedBy="technology")
    public List<Skill> skills;

    @ManyToMany(mappedBy = "portfolioTechnologies")
    private List<Portfolio> portfolios;

    @ManyToMany(mappedBy = "experienceTechnologies")
    private List<Experience> experiences;
}
